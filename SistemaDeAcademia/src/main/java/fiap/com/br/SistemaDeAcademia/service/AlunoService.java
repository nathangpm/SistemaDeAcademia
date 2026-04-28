package fiap.com.br.SistemaDeAcademia.service;

import fiap.com.br.SistemaDeAcademia.exception.ResourceNotFoundException;
import fiap.com.br.SistemaDeAcademia.model.Aluno;
import fiap.com.br.SistemaDeAcademia.projection.AlunoProjection;
import fiap.com.br.SistemaDeAcademia.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    }

    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Aluno buscarPorCpf(String cpf) {
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno aluno) {
        buscarPorId(id);
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        alunoRepository.deleteById(id);
    }

    public Page<Aluno> listarPaginado(Pageable pageable) {
        return alunoRepository.findAll(pageable);
    }

    public Page<Aluno> buscarPorNomePaginado(String nome, Pageable pageable) {
        return alunoRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    public List<AlunoProjection> listarProjection() {
        return alunoRepository.findProjectedBy();
    }
}