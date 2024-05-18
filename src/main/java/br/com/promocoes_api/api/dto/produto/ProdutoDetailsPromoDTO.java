package br.com.promocoes_api.api.dto.produto;


import java.time.LocalDate;

public record ProdutoDetailsPromoDTO(
    Long id, 
    String nome, 
    String descricao, 
    int precoAntes, 
    int precoDepois, 
    LocalDate dataValidade, 
    LocalDate dataUltimaAtualizacaoPreco, 
    String marca, 
    String categoria
) { }