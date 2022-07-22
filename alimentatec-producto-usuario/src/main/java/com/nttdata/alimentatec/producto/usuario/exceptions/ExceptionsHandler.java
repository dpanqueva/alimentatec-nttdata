package com.nttdata.alimentatec.producto.usuario.exceptions;

import com.nttdata.alimentatec.producto.usuario.model.dto.RSProductUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dpanquev
 * @version 2021-09-14
 */
@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

    /**
     * Method obtain error for NotContentException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotContentException.class)
    public ResponseEntity<Map<String, Object>> notContentException(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response());
    }

    /**
     * Method obtain error for BadRequestException
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BadRequestException.class, MissingRequestHeaderException.class})
    public ResponseEntity<Map<String, Object>> batRequestException(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response());
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class, InternalErrorException.class, RuntimeException.class,
            IOException.class, ParseException.class, SocketTimeoutException.class,HttpServerErrorException.class})
    public final ResponseEntity<Map<String, Object>> generalEr(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response());
    }

    /**
     * Method obtain error for BAD_REQUEST from client fsGetSubscriberList
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpClientErrorException.class})
    public final ResponseEntity<Map<String, Object>> exceptionsClientBadRequest(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response());
    }


    private Map<String, Object> response() {

        Map<String, Object> response = new HashMap<>();
        response.put("serviceResponse", new RSProductUserDTO());
        response.put("message", "An unexpected error has occurred!");
        return response;

    }
}
