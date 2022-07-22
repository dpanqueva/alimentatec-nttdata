package com.alimentatec.usernotify.common.security.xss;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {


    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getQueryString() {
        String value = super.getQueryString();
        return StringEscapeUtils.escapeHtml4(value);
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        return StringEscapeUtils.escapeHtml4(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (ArrayUtils.isEmpty(values)) {
            return values;
        }
        int length = values.length;
        String[] escapeValues = new String[length];
        for (int i = 0; i < length; i++) {
            String value = values[i];
            escapeValues[i] = StringEscapeUtils.escapeHtml4(value);
        }
        return escapeValues;
    }

    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return stripXSS(value);
    }

    private String stripXSS(String value) {
        return StringEscapeUtils.escapeHtml4(value);
    }
}
