package br.com.promocoes_api.api.exceptions.produtoException;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
