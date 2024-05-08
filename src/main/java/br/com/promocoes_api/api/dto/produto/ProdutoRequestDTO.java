package br.com.promocoes_api.api.dto.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProdutoRequestDTO(
    Long id, 
    String nome, 
    String descricao, 
    BigDecimal preco, 
    LocalDate dataValidade, 
    String marca, 
    String categoria
) { }