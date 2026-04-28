package fiap.com.br.SistemaDeAcademia.service;

import fiap.com.br.SistemaDeAcademia.exception.ResourceNotFoundException;
import fiap.com.br.SistemaDeAcademia.model.Matricula;
import fiap.com.br.SistemaDeAcademia.model.Matricula.StatusMatricula;
import fiap.com.br.SistemaDeAcademia.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public List<Matricula> listarTodos() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada"));
    }

    public List<Matricula> buscarPorStatus(StatusMatricula status) {
        return matriculaRepository.findByStatus(status);
    }

    public List<Matricula> buscarPorAluno(Long alunoId) {
        return matriculaRepository.findByAlunoId(alunoId);
    }

    public List<Matricula> buscarPorPlano(Long planoId) {
        return matriculaRepository.findByPlanoId(planoId);
    }

    public List<Matricula> buscarVencidas() {
        return matriculaRepository.findByDataVencimentoBefore(LocalDate.now());
    }

    public Matricula salvar(Matricula matricula) {
        if (matricula.getDataVencimento() == null) {
            int dias = matricula.getPlano().getDuracaoDias();
            matricula.setDataVencimento(LocalDate.now().plusDays(dias));
        }
        return matriculaRepository.save(matricula);
    }

    public Matricula atualizar(Long id, Matricula matricula) {
        buscarPorId(id);
        matricula.setId(id);
        return matriculaRepository.save(matricula);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        matriculaRepository.deleteById(id);
    }
}