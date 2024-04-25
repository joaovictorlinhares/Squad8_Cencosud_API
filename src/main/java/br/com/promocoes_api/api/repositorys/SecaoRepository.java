package br.com.promocoes_api.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.promocoes_api.api.models.Secao;
import java.util.Optional;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, Long> {
    Optional<Secao> findById(Long id);
}
