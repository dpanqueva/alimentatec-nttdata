package com.nttdata.ofertassecundarias.common.headers;

import com.nttdata.ofertassecundarias.common.enums.EConstantsVariables;
import com.nttdata.ofertassecundarias.common.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.owasp.html.Sanitizers;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

/**
 * Class for initial configuration xss for attack vulnerability
 *
 * @author dpanquev
 * @version 0.0.1
 */
@Component
@Slf4j
public class BlindHeaders {

    public static String blindParametersHeaders(String headerValue) {
        var policyFactory = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        return policyFactory.sanitize(headerValue);
    }

    public HttpHeaders headersInEvaluate(HttpHeaders headers) {
        var headersOut = new HttpHeaders();
        List<String> lstEvaluate = Arrays.asList(EConstantsVariables.SYSTEM.label, EConstantsVariables.OPERATION.label, EConstantsVariables.EXCETID.label, EConstantsVariables.TIMESTAMP.label, "msgtype");
        lstEvaluate.forEach(ce -> {
            boolean evaluate = headers.containsKey(ce);
            if (!evaluate) {
                throw new BadRequestException("");
            }
            String valHeader = (headers.get(ce).get(0) != null) ? headers.get(ce).get(0) : "";

            if (ce.equalsIgnoreCase("system")) {
                headersOut.add("destination", blindParametersHeaders(valHeader));
            } else if (ce.equalsIgnoreCase("msgtype")) {
                headersOut.add(ce, blindParametersHeaders("RESPONSE"));
            } else if (ce.equalsIgnoreCase("timestamp")) {
                headersOut.add("timestamp", blindParametersHeaders(new Timestamp(System.currentTimeMillis()).toString()));
            } else {
                headersOut.add(ce, blindParametersHeaders(valHeader));
            }
        });
        return headersOut;
    }
}