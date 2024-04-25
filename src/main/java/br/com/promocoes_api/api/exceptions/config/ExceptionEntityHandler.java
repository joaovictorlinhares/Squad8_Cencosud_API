package br.com.promocoes_api.api.exceptions.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.promocoes_api.api.exceptions.secaoException.SecaoNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(SecaoNotFoundException.class)
    public ResponseEntity handlerEventNotFound(SecaoNotFoundException exception) {
        return ResponseEntity.notFound().build();
    };
}
