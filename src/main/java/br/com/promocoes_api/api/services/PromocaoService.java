package br.com.promocoes_api.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.promocoes_api.api.dto.promocao.PromocaoRequestDTO;
import br.com.promocoes_api.api.dto.promocao.PromocaoResponseDTO;
import br.com.promocoes_api.api.exceptions.PromocaoException.PromocaoNotFoundException;
import br.com.promocoes_api.api.models.Promocao;
import br.com.promocoes_api.api.repositorys.PromocaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromocaoService {

    private final PromocaoRepository promocaoRepository;

    public PromocaoResponseDTO getPromocao(Long idPromocao) {
        Promocao promocao = this.promocaoRepository.findById(idPromocao).orElseThrow(() -> new PromocaoNotFoundException("O Id " + idPromocao + " nao existe."));
        return new PromocaoResponseDTO(promocao);
    }

    public PromocaoResponseDTO criarPromocao(PromocaoRequestDTO promocaoRequest) {
        Promocao novaPromocao = new Promocao();
        novaPromocao.setTitulo(promocaoRequest.titulo());
        novaPromocao.setDesconto(promocaoRequest.desconto());
        novaPromocao.setDataInicioPromo(promocaoRequest.dataInicioPromo());
        novaPromocao.setDataFimPromo(promocaoRequest.dataFimPromo());

        this.promocaoRepository.save(novaPromocao);
        return new PromocaoResponseDTO(novaPromocao);
    }

}
