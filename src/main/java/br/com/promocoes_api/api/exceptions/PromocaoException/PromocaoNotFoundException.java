package br.com.promocoes_api.api.exceptions.PromocaoException;

public class PromocaoNotFoundException extends RuntimeException {

    public PromocaoNotFoundException(String mensagem) {
        super(mensagem);
    }

}
