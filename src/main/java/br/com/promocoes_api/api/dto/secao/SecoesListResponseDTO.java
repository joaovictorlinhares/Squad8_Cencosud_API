package br.com.promocoes_api.api.dto.secao;

import java.util.List;

public record SecoesListResponseDTO (
    List<SecaoDTO> secoes
) { }