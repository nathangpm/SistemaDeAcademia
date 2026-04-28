package fiap.com.br.SistemaDeAcademia.service;

import fiap.com.br.SistemaDeAcademia.exception.ResourceNotFoundException;
import fiap.com.br.SistemaDeAcademia.model.Treino;
import fiap.com.br.SistemaDeAcademia.repository.TreinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public Treino buscarPorId(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treino não encontrado"));
    }

    public List<Treino> buscarPorAluno(Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }

    public List<Treino> buscarPorNome(String nome) {
        return treinoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Treino salvar(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino atualizar(Long id, Treino treino) {
        buscarPorId(id);
        treino.setId(id);
        return treinoRepository.save(treino);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        treinoRepository.deleteById(id);
    }
}