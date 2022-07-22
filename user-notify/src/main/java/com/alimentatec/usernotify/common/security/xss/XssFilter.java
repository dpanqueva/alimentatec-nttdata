package com.alimentatec.usernotify.common.security.xss;

import com.alimentatec.usernotify.common.util.HeadersUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class XssFilter implements Filter {

    @Autowired
    private HeadersUtils headersUtils;

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        log.info("Initializing filter :{}", this);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        XssHttpServletRequestWrapper xssHttpServletRequestWrapper = new XssHttpServletRequestWrapper(request);
        /** validate headers from aspect headers valid*/
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        filterChain.doFilter(xssHttpServletRequestWrapper, response);
    }

    @Override
    public void destroy() {
        log.info("Destructing filter :{}", this);
    }
}
