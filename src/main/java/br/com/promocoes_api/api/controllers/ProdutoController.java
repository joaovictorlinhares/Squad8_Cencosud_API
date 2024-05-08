package br.com.promocoes_api.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    private final SecaoService secaoService;
    private final ProdutoService produtoService;

    @PostMapping("/Adicionar/Secao/{idSecao}")
    public ResponseEntity<ProdutoResponseDTO> Adicionar(@PathVariable Long idSecao, @RequestBody ProdutoRequestDTO produto) {
        ProdutoResponseDTO produtoResponse = produtoService.adicionarProduto(idSecao, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

}
