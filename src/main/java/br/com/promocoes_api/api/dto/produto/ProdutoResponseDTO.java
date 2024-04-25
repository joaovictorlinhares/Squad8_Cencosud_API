package br.com.promocoes_api.api.dto.produto;

import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.models.Produto;
import br.com.promocoes_api.api.models.Secao;
import lombok.Getter;

@Getter
public class ProdutoResponseDTO {
    ProdutoDetailsDTO produto;
    SecaoDTO secao;

    public ProdutoResponseDTO(Secao secao, Produto produto) {
        this.secao = new SecaoDTO(
            secao.getId(), 
            secao.getNome()
        );

        this.produto = new ProdutoDetailsDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getDataValidade(),
            produto.getDataUltimaAtualizacaoPreco(),
            produto.getMarca(),
            produto.getCategoria()
        );
    }
}