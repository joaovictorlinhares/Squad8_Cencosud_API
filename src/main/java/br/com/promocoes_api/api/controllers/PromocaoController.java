package br.com.promocoes_api.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.promocoes_api.api.dto.produto.ProdutoRequestDTO;
import br.com.promocoes_api.api.dto.produto.ProdutoResponseDTO;
import br.com.promocoes_api.api.dto.promocao.PromocaoRequestDTO;
import br.com.promocoes_api.api.dto.promocao.PromocaoResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoResponseDTO;
import br.com.promocoes_api.api.services.PromocaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Promoção")
public class PromocaoController {
    private final PromocaoService promocaoService;

    @GetMapping("/{idPromocao}")

    @Operation(summary = "Retorna os detalhes da promoção com o ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Sucesso na busca da promoção.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = PromocaoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "A promoção com o ID fornecido não está cadastrada na base de dados.", content = {@Content})

    public ResponseEntity<PromocaoResponseDTO> getMethodName(@PathVariable Long idPromocao) {
        PromocaoResponseDTO promocaoResponse = this.promocaoService.getPromocao(idPromocao);
        return ResponseEntity.status(HttpStatus.OK).body(promocaoResponse);
    }

    @PostMapping("/Adicionar")

    @Operation(summary = "Adiciona uma nova promoção.")
    @ApiResponse(responseCode = "201", description = "A promoção foi adicionado com sucesso a base de dados.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = PromocaoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possivel cadastradar a promoção na base de dados.", content = {@Content})

    public ResponseEntity<PromocaoResponseDTO> criarPromocao(@RequestBody PromocaoRequestDTO promocaoRequest) {
        PromocaoResponseDTO promocaoResponse = this.promocaoService.criarPromocao(promocaoRequest);    
        return ResponseEntity.status(HttpStatus.CREATED).body(promocaoResponse);
    }

    @PutMapping("/{idPromocao}/Atualizar")

    @Operation(summary = "Atualizar uma promoção.")
    @ApiResponse(responseCode = "200", description = "A promoção foi atualizada com sucesso.", content = {
        @Content(mediaType = "application/json", schema = @Schema(implementation = PromocaoResponseDTO.class))
    })
    @ApiResponse(responseCode = "404", description = "Não foi possivel atualizar a promoção.", content = {@Content})

    public ResponseEntity<PromocaoResponseDTO> atualizarPromocao(@PathVariable Long idPromocao, @RequestBody PromocaoRequestDTO promocao) {
        PromocaoResponseDTO promocaoResponse = this.promocaoService.atualizarPromocao(idPromocao, promocao);
        return ResponseEntity.status(HttpStatus.OK).body(promocaoResponse);
    }

    @DeleteMapping("/{idPromocao}/Deletar")

    @Operation(summary = "Remove uma promoção existente.")
    @ApiResponse(responseCode = "200", description = "A promoção com o ID fornecido foi deletada.", content = {@Content()})
    @ApiResponse(responseCode = "404", description = "Não foi possível excluir a promoção da base de dados.", content = {@Content})

    public ResponseEntity<Void> deletarPromocao(@PathVariable Long idPromocao) {
        this.promocaoService.deletePromocao(idPromocao);
        return ResponseEntity.noContent().build();
    }
}
