package fiap.com.br.SistemaDeAcademia.repository;

import fiap.com.br.SistemaDeAcademia.model.Aluno;
import fiap.com.br.SistemaDeAcademia.projection.AlunoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome);
    Optional<Aluno> findByCpf(String cpf);
    List<Aluno> findByEmail(String email);

    // Paginação
    Page<Aluno> findAll(Pageable pageable);
    Page<Aluno> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    // Projection
    List<AlunoProjection> findProjectedBy();
}