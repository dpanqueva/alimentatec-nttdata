package com.nttdata.productosprimarios.common.headers;

import com.nttdata.productosprimarios.common.model.dto.exception.RequestHeaderExceptionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for initial configuration xss for attack vulnerability
 *
 * @author dpanquev
 * @version 0.0.1
 */
@Component
@Slf4j
public class BlindHeaders implements WebFilter {

    @Value("${headers.required.in}")
    private String headersIn;

    private static final Pattern PATTERN_EVALUATE_EXECID = Pattern
            .compile("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");

    private static final Pattern PATTERN_EVALUATE_TIMESTAMP = Pattern
            .compile("\\d{4}-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\d.\\d\\d\\d[+-]\\d\\d:\\d\\d");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        ServerHttpResponse response = exchange.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        String requestHeaderTag = "Header ";
        if (headersIn != null) {
            List<String> h;
            for (String header : headersIn.split(",")) {
                h = headers.get(header);
                if (h == null) {
                    return writeResponse(response, HttpStatus.BAD_REQUEST, requestHeaderTag + header + " is required", mapper);
                }
                if ((header.equalsIgnoreCase("execId") || header.equalsIgnoreCase("timestamp"))) {
                    Boolean resp = validateExecId(header, h.get(0));
                    if (resp.booleanValue())
                        return writeResponse(response, HttpStatus.BAD_REQUEST, "Header " + header + " no valid for pattern for this request", mapper);
                }
                System.setProperty(header, StringEscapeUtils.escapeHtml4(h.get(0)));
            }
        }
        return chain.filter(exchange);
    }

    @SneakyThrows
    private Mono<Void> writeResponse(ServerHttpResponse response, HttpStatus status, String requestHeader, ObjectMapper objectMapper) {
        RequestHeaderExceptionDTO requestHeaderExceptionDTO = new RequestHeaderExceptionDTO(requestHeader, "400", "Bad request");
        String jsonString = objectMapper.writeValueAsString(requestHeaderExceptionDTO);
        response.setStatusCode(status);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, "application/json;charset=UTF-8");
        DataBufferFactory dbf = response.bufferFactory();
        return response.writeWith(Mono.just(dbf.wrap(jsonString.getBytes())));
    }

    private Boolean validateExecId(String header, String h) {
        if ((header.equalsIgnoreCase("execId")) && (h != null)) {
            Matcher m = PATTERN_EVALUATE_EXECID.matcher(h);
            if (!m.matches())
                return true;
        }
        if ((header.equalsIgnoreCase("timestamp")) && (h != null)) {
            Matcher m = PATTERN_EVALUATE_TIMESTAMP.matcher(h);
            if (!m.matches())
                return true;
        }
        return false;
    }


}
