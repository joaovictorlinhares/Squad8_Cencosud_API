package br.com.promocoes_api.api.dto.produto;

import java.time.LocalDate;

public record ProdutoRequestDTO(
    String nome, 
    String descricao, 
    int preco, 
    LocalDate dataValidade, 
    String marca, 
    String categoria
) { }