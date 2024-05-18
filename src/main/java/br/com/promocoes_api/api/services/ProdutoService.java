package br.com.promocoes_api.api.services;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.promocoes_api.api.dto.produto.ProdutoDetailsDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoListResponseDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoPromocaoResponseDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoRequestDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoResponseDTO;
import br.com.promocoes_api.api.dto.promocao.PromocaoResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoRequestDTO;
import br.com.promocoes_api.api.exceptions.PromocaoException.PromocaoNotFoundException;
import br.com.promocoes_api.api.exceptions.produtoException.ProdutoNotFoundException;
import br.com.promocoes_api.api.exceptions.secaoException.SecaoNotFoundException;
import br.com.promocoes_api.api.models.Produto;
import br.com.promocoes_api.api.models.Promocao;
import br.com.promocoes_api.api.models.Secao;
import br.com.promocoes_api.api.repositorys.ProdutoRepository;
import br.com.promocoes_api.api.repositorys.PromocaoRepository;
import br.com.promocoes_api.api.repositorys.SecaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final SecaoRepository secaoRepository;
    private final PromocaoRepository promocaoRepository ;

    public ProdutoResponseDTO getProduto(Long idProduto) {
        Produto produto = this.produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutoNotFoundException("O Id " + idProduto + " nao existe."));
        return new ProdutoResponseDTO(produto.getSecao(), produto);
    }

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

    public ProdutoResponseDTO adicionarProduto(Long idSecao, ProdutoRequestDTO produtoRequest) {
        Secao secao = this.secaoRepository.findById(idSecao).orElseThrow(() -> new SecaoNotFoundException("A secao com o Id " + idSecao + " nao existe."));

        Produto novoProduto = new Produto();
        novoProduto.setNome(produtoRequest.nome());
        novoProduto.setDescricao(produtoRequest.descricao());
        novoProduto.setPreco(produtoRequest.preco());
        novoProduto.setDataValidade(produtoRequest.dataValidade());
        novoProduto.setMarca(produtoRequest.marca());
        novoProduto.setCategoria(produtoRequest.categoria());
        novoProduto.setSecao(secao);

        this.produtoRepository.save(novoProduto);
        return new ProdutoResponseDTO(secao, novoProduto);
    } 

    public ProdutoResponseDTO atualizarProduto(Long idProduto, ProdutoRequestDTO produtoRequestDTO) {
        Produto existeProduto = this.produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutoNotFoundException("O Id " + idProduto + " nao existe."));

        existeProduto.setNome(produtoRequestDTO.nome());
        existeProduto.setDescricao(produtoRequestDTO.descricao());
        existeProduto.setPreco(produtoRequestDTO.preco());
        existeProduto.setDataValidade(produtoRequestDTO.dataValidade());
        existeProduto.setMarca(produtoRequestDTO.marca());
        existeProduto.setCategoria(produtoRequestDTO.categoria());

        produtoRepository.save(existeProduto);
        return new ProdutoResponseDTO(existeProduto.getSecao(), existeProduto);
    }
    
    public void deleteProduto(Long idProduto) {
        Produto existeProduto = produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutoNotFoundException("O Id " + idProduto + " nao existe."));
        produtoRepository.delete(existeProduto);
    }
    
    public ProdutoPromocaoResponseDTO adicionarPromocaoProduto(Long idProduto, Long idPromocao){
        Produto existeProduto = this.produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutoNotFoundException("O Id do produto " + idProduto + " nao existe."));
        Promocao existePromocao = this.promocaoRepository.findById(idPromocao).orElseThrow(() -> new PromocaoNotFoundException("O Id da promocao " + idPromocao + " nao existe."));
        Secao existeSecao = this.secaoRepository.findById(existeProduto.getSecao().getId()).orElseThrow(() -> new SecaoNotFoundException("A secao com o Id " + existeProduto.getSecao().getId() + " nao existe."));

        existeProduto.setPromocao(existePromocao);

        produtoRepository.save(existeProduto);

        return new ProdutoPromocaoResponseDTO(existeSecao, existeProduto, existePromocao);
    }
}
