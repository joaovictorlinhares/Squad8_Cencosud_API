package br.com.promocoes_api.api.services;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.promocoes_api.api.dto.produto.ProdutoDetailsDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoListResponseDTO;
import br.com.promocoes_api.api.exceptions.secaoException.SecaoNotFoundException;
import br.com.promocoes_api.api.models.Produto;
import br.com.promocoes_api.api.models.Secao;
import br.com.promocoes_api.api.repositorys.ProdutoRepository;
import br.com.promocoes_api.api.repositorys.SecaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final SecaoRepository secaoRepository;

    public List<Produto> getAllProdutosSecao(Long idSecao) {
        List<Produto> listaProdutos = this.produtoRepository.findBySecaoId(idSecao);
        return listaProdutos;
    }

    public ProdutoListResponseDTO getProdutosSecao(Long idSecao) {
        List<Produto> listaProdutos = this.getAllProdutosSecao(idSecao);
        
        Secao secao = this.secaoRepository.findById(idSecao).orElseThrow(() -> new SecaoNotFoundException("A secao com o Id " + idSecao + " nao existe."));
        List<ProdutoDetailsDTO> listaProdutosDetalhada = listaProdutos.stream().map(produto -> {            
            return new ProdutoDetailsDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getDataValidade(), produto.getDataUltimaAtualizacaoPreco(), produto.getMarca(), produto.getCategoria());
        }).toList();
        
        return new ProdutoListResponseDTO(secao, listaProdutosDetalhada);
    }

}
