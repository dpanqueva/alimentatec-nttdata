package com.alimentatec.usernotify.common.headers;

import com.alimentatec.usernotify.common.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.owasp.html.Sanitizers;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
public class BlindHeaders {


    private static final Pattern PATTERN_EVALUATE = Pattern
            .compile("[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}");

    /**
     * Method for evaluate vulnerabilities de XSS
     *
     * @param headerValue
     * @return
     */
    public static String blindParametersHeaders(String headerValue) {
        var policyFactory = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
        return policyFactory.sanitize(headerValue);
    }

    public HttpHeaders headersInEvaluate(HttpHeaders headers) {
        var headersOut = new HttpHeaders();
        Arrays.asList("originator", "userid", "operation", "execid","authorization").forEach(ce -> {
            boolean evaluate = headers.containsKey(ce);
            if (!evaluate) {
                throw new BadRequestException("Header required for this request: ".concat(ce));
            }
            if (ce.equalsIgnoreCase("originator")) {
                headersOut.add(ce, blindParametersHeaders(headers.get(ce).get(0)));

            } else if (ce.equalsIgnoreCase("execid")) {
                if (!validateExecId(headers.get(ce).get(0))) {
                    throw new BadRequestException("Header no valid for pattern for this request: ".concat(ce));
                }
                headersOut.add(ce, blindParametersHeaders(headers.get(ce).get(0)));
            }
        });

        headersOut.add("msgtype", "RESPONSE");
        headersOut.add("vararg", "");
        return headersOut;
    }

    private boolean validateExecId(String execid) {
        boolean check = false;
        if (execid != null) {
            Matcher m = PATTERN_EVALUATE.matcher(execid);
            if (m.matches()) {
                check = true;
            }
        }
        return check;
    }
}
