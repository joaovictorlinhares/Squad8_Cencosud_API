package br.com.promocoes_api.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.promocoes_api.api.dto.produto.ProdutoRequestDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoResponseDTO;
import br.com.promocoes_api.api.dto.promocao.PromocaoRequestDTO;
import br.com.promocoes_api.api.dto.promocao.PromocaoResponseDTO;
import br.com.promocoes_api.api.services.PromocaoService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/API/Promocao")
@AllArgsConstructor
public class PromocaoController {
    private final PromocaoService promocaoService;

    @GetMapping("/{idPromocao}")
    public ResponseEntity<PromocaoResponseDTO> getMethodName(@PathVariable Long idPromocao) {
        try {
            PromocaoResponseDTO promocaoResponse = this.promocaoService.getPromocao(idPromocao);
            return ResponseEntity.status(HttpStatus.OK).body(promocaoResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @PostMapping("/Adicionar")
    public ResponseEntity<PromocaoResponseDTO> criarPromocao(@RequestBody PromocaoRequestDTO promocaoRequest) {
        PromocaoResponseDTO promocaoResponse = this.promocaoService.criarPromocao(promocaoRequest);    
        return ResponseEntity.status(HttpStatus.CREATED).body(promocaoResponse);
    }

    @PutMapping("/{idPromocao}/Atualizar")
    public ResponseEntity<PromocaoResponseDTO> atualizarPromocao(@PathVariable Long idPromocao, @RequestBody PromocaoRequestDTO promocao) {
        PromocaoResponseDTO promocaoResponse = this.promocaoService.atualizarPromocao(idPromocao, promocao);
        return ResponseEntity.status(HttpStatus.OK).body(promocaoResponse);
    }

    @DeleteMapping("/{idPromocao}/Deletar")
    public ResponseEntity<Void> deletarPromocao(@PathVariable Long idPromocao) {
        this.promocaoService.deletePromocao(idPromocao);
        return ResponseEntity.noContent().build();
    }
}
