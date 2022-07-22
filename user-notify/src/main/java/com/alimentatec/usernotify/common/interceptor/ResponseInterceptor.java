package com.alimentatec.usernotify.common.interceptor;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseInterceptor implements HandlerInterceptor {

    @Value("${headers.required.out}")
    private String headersRequiredOut;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        MultiValueMap<String, String> head = new HttpHeaders();
        if (headersRequiredOut != null) {
            for (String header : headersRequiredOut.split(",")) {
                String h = StringEscapeUtils.escapeHtml4(request.getHeader(header));
                head.add(header, h);
            }
            head.addAll(head);
        }

    }

}
