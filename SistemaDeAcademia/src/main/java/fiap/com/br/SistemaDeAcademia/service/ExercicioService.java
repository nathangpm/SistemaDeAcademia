package fiap.com.br.SistemaDeAcademia.service;

import fiap.com.br.SistemaDeAcademia.exception.ResourceNotFoundException;
import fiap.com.br.SistemaDeAcademia.model.Exercicio;
import fiap.com.br.SistemaDeAcademia.repository.ExercicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public List<Exercicio> listarTodos() {
        return exercicioRepository.findAll();
    }

    public Exercicio buscarPorId(Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercício não encontrado"));
    }

    public List<Exercicio> buscarPorGrupoMuscular(String grupoMuscular) {
        return exercicioRepository.findByGrupoMuscularIgnoreCase(grupoMuscular);
    }

    public List<Exercicio> buscarPorTreino(Long treinoId) {
        return exercicioRepository.findByTreinoId(treinoId);
    }

    public Exercicio salvar(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public Exercicio atualizar(Long id, Exercicio exercicio) {
        buscarPorId(id);
        exercicio.setId(id);
        return exercicioRepository.save(exercicio);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        exercicioRepository.deleteById(id);
    }
}