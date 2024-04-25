package br.com.promocoes_api.api.services;

import org.springframework.stereotype.Service;
import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoRequestDTO;
import br.com.promocoes_api.api.dto.secao.SecaoResponseDTO;
import br.com.promocoes_api.api.exceptions.secaoException.SecaoNotFoundException;
import br.com.promocoes_api.api.models.Secao;
import br.com.promocoes_api.api.repositorys.SecaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecaoService {

    private final SecaoRepository secaoRepository;

    public SecaoResponseDTO getSecao(Long idSecao) {
        Secao secao = this.secaoRepository.findById(idSecao).orElseThrow(() -> new SecaoNotFoundException("O Id " + idSecao + " nao existe."));
        return new SecaoResponseDTO(secao);
    }

    public SecaoDTO criarSecao(SecaoRequestDTO secaoRequestDTO) {
        Secao novaSecao = new Secao();
        novaSecao.setNome(secaoRequestDTO.nomeSecao());

        this.secaoRepository.save(novaSecao);
        return new SecaoDTO(novaSecao.getId(), novaSecao.getNome());
    }
}
