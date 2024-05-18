package br.com.promocoes_api.api.dto.promocao;


import java.time.LocalDate;

public record PromocaoDTO(
    Long id,
    String titulo,
    int desconto,
    LocalDate dataInicioPromo,
    LocalDate dataFimPromo
) {}