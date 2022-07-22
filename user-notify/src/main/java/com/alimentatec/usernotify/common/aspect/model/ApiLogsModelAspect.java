package com.alimentatec.usernotify.common.aspect.model;

import com.alimentatec.usernotify.common.util.HeadersUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
@Aspect
public class ApiLogsModelAspect {
    @Autowired
    private HeadersUtils headersUtils;

    @Pointcut("execution(* com.telefonica.campaigntrazability.model.repository.*.*(..))")
    public void allRepositoryConsume() {
        log.info("Log integration");
    }

    @Before("allRepositoryConsume()")
    public void requestRepositoryConsume(JoinPoint jp) {
        HashMap<String, Object> request = new HashMap<>();
        StringBuilder log = new StringBuilder();
        log.append(jp.getSignature().getName()).append(">>> ");
        for (Object arg : jp.getArgs()) {
            log.append("parameter ").append(arg);
        }
        request.put("parameter", log);
        request.put("tipoPeticion", true);
        request.put("headers-model", headersUtils.buildHeadersForClient());

        headersUtils.printLog("INFO", null, null, request);
    }

    /**
     * Response client consume
     */
    @AfterReturning(pointcut = "allRepositoryConsume()", returning = "result")
    public void responseClientConsume(JoinPoint jp, Object result) {
        HashMap<String, Object> request = new HashMap<>();

        StringBuilder log = new StringBuilder();
        log.append(jp.getSignature().getName()).append(">>> ");
        for (Object arg : jp.getArgs()) {
            log.append("parameter ").append(arg);

        }
        request.put("parameter", log);
        request.put("responseClient", result);
        request.put("headers-client", headersUtils.buildHeadersForClient());
        headersUtils.printLog("INFO", null, null, request);
    }
}
