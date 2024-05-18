package br.com.promocoes_api.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.promocoes_api.api.dto.secao.SecaoDTO;
import br.com.promocoes_api.api.dto.secao.SecaoRequestDTO;
import br.com.promocoes_api.api.dto.secao.SecaoResponseDTO;
import br.com.promocoes_api.api.dto.secao.SecoesListResponseDTO;
import br.com.promocoes_api.api.exceptions.secaoException.SecaoNotFoundException;
import br.com.promocoes_api.api.models.Produto;
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

    public SecoesListResponseDTO getSecoes() {
        List<Secao> secoes = this.secaoRepository.findAll();

        List<SecaoDTO> listaSecoesDTO = secoes.stream().map(secao -> {            
            return new SecaoDTO(secao.getId(), secao.getNome());
        }).toList();
        return new SecoesListResponseDTO(listaSecoesDTO);
    }

    public SecaoDTO criarSecao(SecaoRequestDTO secaoRequestDTO) {
        Secao novaSecao = new Secao();
        novaSecao.setNome(secaoRequestDTO.nome());

        this.secaoRepository.save(novaSecao);
        return new SecaoDTO(novaSecao.getId(), novaSecao.getNome());
    }

    public SecaoDTO atualizarSecao(Long idSecao, SecaoRequestDTO secaoRequestDTO) {
        Secao existeSecao = this.secaoRepository.findById(idSecao).orElseThrow(() -> new SecaoNotFoundException("O Id " + idSecao + " nao existe."));

        existeSecao.setNome(secaoRequestDTO.nome());

        secaoRepository.save(existeSecao);
        return new SecaoDTO(existeSecao.getId(), existeSecao.getNome());
    }

    public void deleteSecao(Long idSecao) {
        Secao existeSecao = secaoRepository.findById(idSecao).orElseThrow(() -> new SecaoNotFoundException("O Id " + idSecao + " nao existe."));
        secaoRepository.delete(existeSecao);
    }
}
