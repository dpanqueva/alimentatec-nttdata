package com.alimentatec.usernotify.common.util;


import com.alimentatec.usernotify.common.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class HeadersUtils extends ProjectUtils {

    @Value("${headers.required.out}")
    private String headersROut;

    @Value("${headers.required.in}")
    private String headersRIn;

    private static final Pattern PATTERN_EVALUATE = Pattern
            .compile("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");

    /**
     * Method for iterator for each variable required headers out
     *
     * @param headers
     */
    public void validateHeadersIn(HttpHeaders headers) {
        if (headersRIn != null) {
            List<String> h;
            for (String header : headersRIn.split(",")) {
                h = headers.get(header);
                if (h == null) {
                    throw new BadRequestException("Header required for this request: ".concat(header));
                }
                if (header.equalsIgnoreCase("execid")) {
                    validateExecId(h.get(0));
                }
                System.setProperty(header, StringEscapeUtils.escapeHtml4(h.get(0)));
            }
        }
    }

    /**
     * Method for validate execId for pattern defined
     */
    private String validateExecId(String execid) {
        if (execid != null) {
            Matcher m = PATTERN_EVALUATE.matcher(execid);
            if (!m.matches()) {
                throw new BadRequestException("Header no valid for pattern for this request: ".concat(execid));
            }
        }
        return execid;
    }

    /**
     * Build headers for send other clients
     */
    public HttpHeaders buildHeadersForClient() {
        HttpHeaders headers = new HttpHeaders();
        if (headersRIn != null) {
            for (String header : headersRIn.split(",")) {
                headers.set(header, StringEscapeUtils.escapeHtml4(System.getProperty(header)));
            }
        }
        headers.set("country", StringEscapeUtils.escapeHtml4("CO"));
        headers.set("lang", StringEscapeUtils.escapeHtml4("lang"));
        headers.set("entity", StringEscapeUtils.escapeHtml4("entity"));
        headers.set("subsystem", StringEscapeUtils.escapeHtml4("subscriber-information"));
        headers.set("system", StringEscapeUtils.escapeHtml4("subscriber-information"));
        headers.set("destination", StringEscapeUtils.escapeHtml4("subscriber-list"));
        headers.set("timestamp", StringEscapeUtils.escapeHtml4(buildTimeForHeader()));
        return headers;
    }

    /**
     * Build time for header
     */
    private String buildTimeForHeader() {
        String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH).format(new Date());
        return date.concat("+01:00");
    }


}
