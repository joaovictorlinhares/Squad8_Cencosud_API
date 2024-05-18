package br.com.promocoes_api.api.dto.produto;

import br.com.promocoes_api.api.dto.promocao.PromocaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.models.Produto;
import br.com.promocoes_api.api.models.Promocao;
import br.com.promocoes_api.api.models.Secao;
import lombok.Getter;

@Getter
public class ProdutoPromocaoResponseDTO {
    ProdutoDetailsPromoDTO produto;
    SecaoDTO secao;
    PromocaoDTO promocao;

    public ProdutoPromocaoResponseDTO(Secao secao, Produto produto, Promocao promocao) {
        this.secao = new SecaoDTO(
            secao.getId(), 
            secao.getNome()
        );

        this.produto = new ProdutoDetailsPromoDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getPreco() * (promocao.getDesconto() / 100),
            produto.getDataValidade(),
            produto.getDataUltimaAtualizacaoPreco(),
            produto.getMarca(),
            produto.getCategoria()
        );

        this.promocao = new PromocaoDTO(
            promocao.getId(), 
            promocao.getTitulo(), 
            promocao.getDesconto(), 
            promocao.getDataInicioPromo(), 
            promocao.getDataFimPromo()
        );
    }
}