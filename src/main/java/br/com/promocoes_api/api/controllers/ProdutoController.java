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

import br.com.promocoes_api.api.dto.produto.ProdutoPromocaoResponseDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoRequestDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoResponseDTO;
import br.com.promocoes_api.api.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/API/Produto")
@AllArgsConstructor
@Tag(name = "Produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/{idProduto}")

    @Operation(summary = "Retorna os detalhes do produto com o ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Sucesso na busca do produto.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "O produto com o ID fornecido não está cadastrada na base de dados.", content = {@Content})

    public ResponseEntity<ProdutoResponseDTO> getSecao(@PathVariable Long idProduto) {
        ProdutoResponseDTO produtoResponse = this.produtoService.getProduto(idProduto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @PostMapping("/Adicionar/Secao/{idSecao}")

    @Operation(summary = "Adiciona um novo produto à seção especificada.")
    @ApiResponse(responseCode = "201", description = "O produto foi adicionado com sucesso a base de dados.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possivel cadastradar o produto na base de dados.", content = {@Content})

    public ResponseEntity<ProdutoResponseDTO> Adicionar(@PathVariable Long idSecao, @RequestBody ProdutoRequestDTO produto) {
        ProdutoResponseDTO produtoResponse = produtoService.adicionarProduto(idSecao, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @PutMapping("/{idProduto}/Atualizar")

    @Operation(summary = "Atualiza os detalhes de um produto existente.")
    @ApiResponse(responseCode = "200", description = "O produto com o ID fornecido foi atualizado.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possivel atualizar o produto na base de dados.", content = {@Content})

    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@PathVariable Long idProduto, @RequestBody ProdutoRequestDTO produto) {
        ProdutoResponseDTO produtoResponse = this.produtoService.atualizarProduto(idProduto, produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @DeleteMapping("/{idProduto}/Deletar")

    @Operation(summary = "Remove um produto existente.")
    @ApiResponse(responseCode = "200", description = "O produto com o ID fornecido foi deletado.", content = {@Content()})
    @ApiResponse(responseCode = "404", description = "Não foi possível excluir o produto da base de dados.", content = {@Content})

    public ResponseEntity<Void> deletarProduto(@PathVariable Long idProduto) {
        this.produtoService.deleteProduto(idProduto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idProduto}/Promocao/{idPromocao}")

    @Operation(summary = "Adiciona uma promoção a um produto.")
    @ApiResponse(responseCode = "200", description = "A promoção foi adicionada ao produto informado.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoPromocaoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possível adicionar a promoção ao produto solicitado.", content = {@Content})

    public ResponseEntity<ProdutoPromocaoResponseDTO> adicionarPromocaoProduto(@PathVariable Long idProduto, @PathVariable Long idPromocao) {
        ProdutoPromocaoResponseDTO produtoResponse = this.produtoService.adicionarPromocaoProduto(idProduto, idPromocao);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }
}
