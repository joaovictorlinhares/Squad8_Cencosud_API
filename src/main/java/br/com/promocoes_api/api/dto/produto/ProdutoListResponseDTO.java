package br.com.promocoes_api.api.dto.produto;

import java.util.List;
import br.com.promocoes_api.api.models.Secao;

public record ProdutoListResponseDTO (
    Secao secao, 
    List<ProdutoDetailsDTO> produtos
) { }