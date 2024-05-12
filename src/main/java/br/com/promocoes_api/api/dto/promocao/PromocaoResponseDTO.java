package br.com.promocoes_api.api.dto.promocao;

import br.com.promocoes_api.api.models.Promocao;
import lombok.Getter;

@Getter
public class PromocaoResponseDTO {
    PromocaoDTO promocao;

    public PromocaoResponseDTO(Promocao promocao) {
        this.promocao = new 
        PromocaoDTO(
            promocao.getId(), 
            promocao.getTitulo(), 
            promocao.getDesconto(), 
            promocao.getDataInicioPromo(), 
            promocao.getDataFimPromo());
    }
}
