package br.com.promocoes_api.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.promocoes_api.api.dto.produto.ProdutoListResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoRequestDTO;
import br.com.promocoes_api.api.dto.secao.SecaoResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecoesListResponseDTO;
import br.com.promocoes_api.api.services.ProdutoService;
import br.com.promocoes_api.api.services.SecaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/API/Secao")
@AllArgsConstructor
public class SecaoController {

    private final SecaoService secaoService;
    private final ProdutoService produtoService;

    @GetMapping("/{idSecao}")
    public ResponseEntity<SecaoResponseDTO> getSecao(@PathVariable Long idSecao) {
        SecaoResponseDTO secaoResponse = this.secaoService.getSecao(idSecao);
        return ResponseEntity.status(HttpStatus.OK).body(secaoResponse);
    }

    @GetMapping("/Listar")
    public ResponseEntity<SecoesListResponseDTO> getListarSecoes() {
        SecoesListResponseDTO secaoResponse = this.secaoService.getSecoes();
        return ResponseEntity.status(HttpStatus.OK).body(secaoResponse);
    }

    @PostMapping("/Adicionar")
    public ResponseEntity<SecaoDTO> criarSecao(@RequestBody SecaoRequestDTO secaoRequestBody) {
        SecaoDTO secaoResponse = this.secaoService.criarSecao(secaoRequestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(secaoResponse);
    }

    @PutMapping("/{idSecao}/Atualizar")
    public ResponseEntity<SecaoDTO> atualizarSecao(@PathVariable Long idSecao, @RequestBody SecaoRequestDTO secaoRequestBody) {
        SecaoDTO secaoResponse = this.secaoService.atualizarSecao(idSecao, secaoRequestBody);
        return ResponseEntity.status(HttpStatus.OK).body(secaoResponse);
    }

    @DeleteMapping("/{idSecao}/Deletar")
    public ResponseEntity<Void> deletarSecao(@PathVariable Long idSecao) {
        this.secaoService.deleteSecao(idSecao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idSecao}/Produtos")
    public ResponseEntity<ProdutoListResponseDTO> getProdutosSecao(@PathVariable Long idSecao) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getProdutosSecao(idSecao));
        
    }
    
}
