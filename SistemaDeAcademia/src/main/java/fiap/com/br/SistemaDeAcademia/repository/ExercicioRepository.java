package fiap.com.br.SistemaDeAcademia.repository;

import fiap.com.br.SistemaDeAcademia.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

    List<Exercicio> findByGrupoMuscularIgnoreCase(String grupoMuscular);
    List<Exercicio> findByTreinoId(Long treinoId);
}