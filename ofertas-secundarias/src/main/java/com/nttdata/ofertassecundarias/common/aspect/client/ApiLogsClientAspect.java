package com.nttdata.ofertassecundarias.common.aspect.client;

import com.nttdata.ofertassecundarias.common.util.HeadersUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author dpanquev
 * @version 2021-11-18
 * Class for all integration about client consume
 */
@Slf4j
@Component
@Aspect
public class ApiLogsClientAspect {

    @Autowired
    private HeadersUtils headersUtils;

    @Pointcut("execution(* com.nttdata.ofertassecundarias.model.client.*.*(..))")
    public void allClientsConsume() {
        log.info("Log integration");
    }

    /**
     * Request client consume
     * url
     * method
     */
    @Before("allClientsConsume()")
    public void requestClientConsume(JoinPoint jp) {
        HashMap<String, Object> request = new HashMap<>();
        StringBuilder log = new StringBuilder();
        log.append(jp.getSignature().getName()).append(">>> ");
        for (Object arg : jp.getArgs()) {
            log.append("parameter ").append(arg);
        }
        request.put("parameter", log);
        request.put("tipoPeticion", true);
        request.put("headers-client", headersUtils.buildHeadersForClient());

        headersUtils.printLog("INFO", null, null, request);
    }

    /**
     * Response client consume
     */
    @AfterReturning(pointcut = "allClientsConsume()", returning = "result")
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
