package com.david.backendCursoJava.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<ExceptionApiDTO> handleExceptionEmail(EmailExistsException ex){
        return new ResponseEntity<>(new ExceptionApiDTO("Error con el email", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionApiDTO> handleException(Exception ex){
        return new ResponseEntity<>(new ExceptionApiDTO("Error API", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
