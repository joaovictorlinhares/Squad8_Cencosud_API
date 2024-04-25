package br.com.promocoes_api.api.dto.secao;

import br.com.promocoes_api.api.models.Secao;
import lombok.Getter;

@Getter
public class SecaoResponseDTO {

    SecaoDTO secao;

    public SecaoResponseDTO(Secao secao) {
        this.secao = new SecaoDTO(secao.getId(), secao.getNome());
    }
}
