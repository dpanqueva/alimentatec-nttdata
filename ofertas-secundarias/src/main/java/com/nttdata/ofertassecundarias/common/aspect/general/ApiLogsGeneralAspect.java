package com.nttdata.ofertassecundarias.common.aspect.general;

import com.nttdata.ofertassecundarias.common.model.enums.EConstantsVariables;
import com.nttdata.ofertassecundarias.common.util.HeadersUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author dpanquev
 * @version 2021-11-18
 * Class for all logs about process
 */
@Slf4j
@Component
@Aspect
public class ApiLogsGeneralAspect {

    @Autowired
    private HeadersUtils headersUtils;

    /**
     * Method for point cut and start logs for process
     */
    @Pointcut("execution(* com.nttdata.ofertassecundarias.controller.*.*(..))")
    public void allEventsFromController() {
        log.info("Log event");
    }

    /**
     * Method for log entry
     *
     * @param jp
     */
    @Before("allEventsFromController()")
    public void entryPoint(JoinPoint jp) {
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info("Log Event");
        HashMap<String, Object> isIntegration = new HashMap<>();
        StringBuilder log = new StringBuilder();
        System.setProperty(EConstantsVariables.METHOD_NAME.label, jp.getSignature().getName());
        System.setProperty("timeInit", String.valueOf(System.currentTimeMillis()));
        log.append(jp.getSignature().getName()).append(">>> ");
        HttpHeaders headers = null;
        for (Object arg : jp.getArgs()) {
            if (arg instanceof HttpHeaders) {
                headers = (HttpHeaders) arg;
                headersUtils.validateHeadersIn(headers);
            } else {
                log.append("parameter ").append(arg);
            }
        }
        headersUtils.printLog("INFO", headers, null, isIntegration);
    }

    /**
     * Method for the control after response
     *
     * @param jp
     * @param result
     */
    @AfterReturning(pointcut = "allEventsFromController()", returning = "result")
    public void exitPoint(JoinPoint jp, Object result) {
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info("Log Event");
        HashMap<String, Object> isIntegration = new HashMap<>();
        System.setProperty(EConstantsVariables.METHOD_NAME.label, jp.getSignature().getName());
        StringBuilder log = new StringBuilder();
        log.append(jp.getSignature().getName()).append(">>> ");
        headersUtils.printLog("INFO", null, result, isIntegration);
    }

    /**
     * Method for to view all errors in this application microservice
     *
     * @param exception
     * @param jp
     */
    @AfterThrowing(pointcut = "allEventsFromController()", throwing = "exception")
    public void c(JoinPoint jp, Exception exception) {
        LogManager.getLogger(jp.getSignature().getDeclaringTypeName()).info("Log Error");
        HashMap<String, Object> isIntegration = new HashMap<>();
        System.setProperty("msnError", exception.getMessage());
        System.setProperty("errorName", exception.getClass().getSimpleName());
        System.setProperty("methodName", jp.getSignature().getName());
        headersUtils.printLog("ERROR", null, null, isIntegration);
    }
}
