package br.com.promocoes_api.api.repositorys;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.promocoes_api.api.models.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Long> {
    Optional<Promocao> findById(Long id);
}
