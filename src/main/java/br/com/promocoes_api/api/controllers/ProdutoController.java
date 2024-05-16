package br.com.promocoes_api.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.promocoes_api.api.dto.produto.ProdutoRequestDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoResponseDTO;
import br.com.promocoes_api.api.services.ProdutoService;
import br.com.promocoes_api.api.services.SecaoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/API/Produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/{idProduto}")
    public ResponseEntity<ProdutoResponseDTO> getSecao(@PathVariable Long idProduto) {
        ProdutoResponseDTO produtoResponse = this.produtoService.getProduto(idProduto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @PostMapping("/Adicionar/Secao/{idSecao}")
    public ResponseEntity<ProdutoResponseDTO> Adicionar(@PathVariable Long idSecao, @RequestBody ProdutoRequestDTO produto) {
        ProdutoResponseDTO produtoResponse = produtoService.adicionarProduto(idSecao, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @PutMapping("/{idProduto}/Atualizar")
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoRequestDTO produto) {
        ProdutoResponseDTO produtoResponse = this.produtoService.atualizarProduto(idProduto, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @DeleteMapping("/{idProduto}/Deletar")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long idProduto) {
        this.produtoService.deleteProduto(idProduto);
        return ResponseEntity.noContent().build();
    }
}
