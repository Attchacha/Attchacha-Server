package com.azaza.attchach_back.global.exception.handler;

import com.azaza.attchach_back.global.exception.IdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorMessage> invalidEmailExceptionHandler(IdNotFoundException e){
        return ResponseEntity.status(e.getStatus())
                .body(ErrorMessageFactory.from(e.getStatus(), e.getErrorMessage()));
    }
}
