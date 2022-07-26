package com.nttdata.productosprimarios.common.exception;


import com.nttdata.productosprimarios.common.model.dto.response.ResponseDTO;
import com.nttdata.productosprimarios.common.model.enums.EResponseType;
import com.nttdata.productosprimarios.model.document.PrimaryProductDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

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
    public ResponseEntity<Object> notContentException(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDTO<>(response(), EResponseType.NO_CONTENT, e.getMessage(), "204"));
    }

    /**
     * Method obtain error for BadRequestException
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BadRequestException.class, ConstraintViolationException.class})
    public ResponseEntity<ResponseDTO<Object>> batRequestException(Exception e) {
        log.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(response(), EResponseType.BAD_REQUEST, e.getMessage(), "400"));
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR
     *
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class, InternalErrorException.class, RuntimeException.class,
            IOException.class, ParseException.class, SocketTimeoutException.class})
    public final ResponseEntity<ResponseDTO<Object>> exceptionsGeneral(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Se ha presentado un error inesperado", "500"));
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR from client fsGetSubscriberList
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpServerErrorException.class})
    public final ResponseEntity<ResponseDTO<Object>> exceptionsClientInternalServerError(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Internal server error by FsGetSubscriberList", "500"));
    }

    /**
     * Method obtain error for BAD_REQUEST from client fsGetSubscriberList
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpClientErrorException.class})
    public final ResponseEntity<ResponseDTO<Object>> exceptionsClientBadRequest(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Bad Request by FsGetSubscriberList", "400"));
    }

    private PrimaryProductDocument response() {
        return null;
    }
}
