package com.nttdata.alimentatec.usuarios.exception;


import com.nttdata.alimentatec.usuarios.model.dto.UserDTO;
import com.nttdata.alimentatec.usuarios.model.dto.response.ResponseDTO;
import com.nttdata.alimentatec.usuarios.model.enums.EResponseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
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
    @ExceptionHandler({BadRequestException.class, ConstraintViolationException.class, MissingRequestHeaderException.class})
    public ResponseEntity<ResponseDTO<UserDTO>> batRequestException(Exception e) {
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
    public final ResponseEntity<ResponseDTO<UserDTO>> exceptionsGeneral(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Se ha presentado un error inesperado", "500"));
    }

    /**
     * Method obtain error for INTERNAL_SERVER_ERROR from client
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpServerErrorException.class})
    public final ResponseEntity<ResponseDTO<Object>> exceptionsClientInternalServerError(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Internal server error by ", "500"));
    }

    /**
     * Method obtain error for BAD_REQUEST from client
     *
     * @param e
     * @return
     */
    @ExceptionHandler({HttpClientErrorException.class})
    public final ResponseEntity<ResponseDTO<UserDTO>> exceptionsClientBadRequest(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        if (e.getMessage().contains("1050")) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseDTO<>(response(), EResponseType.NO_CONTENT, e.getMessage(), "204"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(response(), EResponseType.ERROR, "Bad Request by ", "400"));
    }


    private UserDTO response() {
        return new UserDTO();
    }
}
