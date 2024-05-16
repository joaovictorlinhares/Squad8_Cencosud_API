package br.com.promocoes_api.api.exceptions.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.promocoes_api.api.exceptions.PromocaoException.PromocaoNotFoundException;
import br.com.promocoes_api.api.exceptions.produtoException.ProdutoNotFoundException;
import br.com.promocoes_api.api.exceptions.secaoException.SecaoNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(SecaoNotFoundException.class)
    public ResponseEntity handlerEventNotFound(SecaoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    };

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity handlerEventNotFound(ProdutoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    };

    @ExceptionHandler(PromocaoNotFoundException.class)
    public ResponseEntity handlerEventNotFound(PromocaoNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    };
}
