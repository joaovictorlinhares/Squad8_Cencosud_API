package br.com.promocoes_api.api.dto.promocao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PromocaoDTO(
    Long id,
    String titulo,
    BigDecimal desconto,
    LocalDate dataInicioPromo,
    LocalDate dataFimPromo
) {}