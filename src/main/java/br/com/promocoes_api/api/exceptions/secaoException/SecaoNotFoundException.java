package br.com.promocoes_api.api.exceptions.secaoException;

public class SecaoNotFoundException extends RuntimeException {

    public SecaoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
