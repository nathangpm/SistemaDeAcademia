package fiap.com.br.SistemaDeAcademia.repository;

import fiap.com.br.SistemaDeAcademia.model.Matricula;
import fiap.com.br.SistemaDeAcademia.model.Matricula.StatusMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByStatus(StatusMatricula status);
    List<Matricula> findByAlunoId(Long alunoId);
    List<Matricula> findByPlanoId(Long planoId);
    List<Matricula> findByDataVencimentoBefore(LocalDate data);
}