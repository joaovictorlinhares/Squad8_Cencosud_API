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
import br.com.promocoes_api.api.dto.produto.ProdutoResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoRequestDTO;
import br.com.promocoes_api.api.dto.secao.SecaoResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecoesListResponseDTO;
import br.com.promocoes_api.api.services.ProdutoService;
import br.com.promocoes_api.api.services.SecaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/API/Secao")
@AllArgsConstructor
@Tag(name = "Seção")
public class SecaoController {

    private final SecaoService secaoService;
    private final ProdutoService produtoService;

    @GetMapping("/{idSecao}")

    @Operation(summary = "Retorna os detalhes da seção com o ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Sucesso na busca da seção.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = SecaoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "A seção com o ID fornecido não está cadastrada na base de dados.", content = {@Content})

    public ResponseEntity<SecaoResponseDTO> getSecao(@PathVariable Long idSecao) {
        SecaoResponseDTO secaoResponse = this.secaoService.getSecao(idSecao);
        return ResponseEntity.status(HttpStatus.OK).body(secaoResponse);
    }

    @GetMapping("/Listar")

    @Operation(summary = "Lista todas as seções cadastradas.")
    @ApiResponse(responseCode = "200", description = "Retorna as seções cadastradas na base de dados.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = SecoesListResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não há seções cadastradas.", content = {@Content})

    public ResponseEntity<SecoesListResponseDTO> getListarSecoes() {
        SecoesListResponseDTO secaoResponse = this.secaoService.getSecoes();
        return ResponseEntity.status(HttpStatus.OK).body(secaoResponse);
    }

    @PostMapping("/Adicionar")

    @Operation(summary = "Adiciona uma nova seção.")
    @ApiResponse(responseCode = "201", description = "A seção foi adicionado com sucesso a base de dados.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = SecaoDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possivel cadastradar a seção na base de dados.", content = {@Content})

    public ResponseEntity<SecaoDTO> criarSecao(@RequestBody SecaoRequestDTO secaoRequestBody) {
        SecaoDTO secaoResponse = this.secaoService.criarSecao(secaoRequestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(secaoResponse);
    }

    @PutMapping("/{idSecao}/Atualizar")

    @Operation(summary = "Atualizar uma seção.")
    @ApiResponse(responseCode = "200", description = "A seção foi atualizada com sucesso.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = SecaoDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possivel atualizar a seção.", content = {@Content})

    public ResponseEntity<SecaoDTO> atualizarSecao(@PathVariable Long idSecao, @RequestBody SecaoRequestDTO secaoRequestBody) {
        SecaoDTO secaoResponse = this.secaoService.atualizarSecao(idSecao, secaoRequestBody);
        return ResponseEntity.status(HttpStatus.OK).body(secaoResponse);
    }

    @DeleteMapping("/{idSecao}/Deletar")

    @Operation(summary = "Remove uma seção existente.")
    @ApiResponse(responseCode = "200", description = "A seção com o ID fornecido foi deletada.", content = {@Content()})
    @ApiResponse(responseCode = "404", description = "Não foi possível excluir a seção da base de dados.", content = {@Content})

    public ResponseEntity<Void> deletarSecao(@PathVariable Long idSecao) {
        this.secaoService.deleteSecao(idSecao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idSecao}/Produtos")

    @Operation(summary = "Busca os produtos de uma seção.")
    @ApiResponse(responseCode = "200", description = "Retorna a seção e uma lista de produtos da mesma.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoListResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "O seção com o ID fornecido não está cadastrada na base de dados.", content = {@Content})

    public ResponseEntity<ProdutoListResponseDTO> getProdutosSecao(@PathVariable Long idSecao) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getProdutosSecao(idSecao));
        
    }
    
}
