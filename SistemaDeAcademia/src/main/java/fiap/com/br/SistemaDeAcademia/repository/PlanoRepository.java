package fiap.com.br.SistemaDeAcademia.repository;

import fiap.com.br.SistemaDeAcademia.model.Plano;
import fiap.com.br.SistemaDeAcademia.projection.PlanoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    List<Plano> findByNomeContainingIgnoreCase(String nome);
    List<Plano> findByPrecoBetween(Double precoMin, Double precoMax);

    // Paginação
    Page<Plano> findAll(Pageable pageable);

    // Projection
    List<PlanoProjection> findProjectedBy();
}