package br.com.promocoes_api.api.dto.produto;

import java.time.LocalDate;

public record ProdutoDetailsDTO(
    Long id, 
    String nome, 
    String descricao, 
    int preco, 
    LocalDate dataValidade, 
    LocalDate dataUltimaAtualizacaoPreco, 
    String marca, 
    String categoria
) { }