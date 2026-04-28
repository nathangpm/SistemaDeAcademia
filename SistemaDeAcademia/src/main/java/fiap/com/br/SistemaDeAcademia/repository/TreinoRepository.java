package fiap.com.br.SistemaDeAcademia.repository;

import fiap.com.br.SistemaDeAcademia.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

    List<Treino> findByAlunoId(Long alunoId);
    List<Treino> findByNomeContainingIgnoreCase(String nome);
}