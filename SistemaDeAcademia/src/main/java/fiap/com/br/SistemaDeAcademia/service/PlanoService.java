package fiap.com.br.SistemaDeAcademia.service;

import fiap.com.br.SistemaDeAcademia.exception.ResourceNotFoundException;
import fiap.com.br.SistemaDeAcademia.model.Plano;
import fiap.com.br.SistemaDeAcademia.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoRepository planoRepository;

    public List<Plano> listarTodos() {
        return planoRepository.findAll();
    }

    public Plano buscarPorId(Long id) {
        return planoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado"));
    }

    public List<Plano> buscarPorNome(String nome) {
        return planoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Plano> buscarPorFaixa(Double precoMin, Double precoMax) {
        return planoRepository.findByPrecoBetween(precoMin, precoMax);
    }

    public Plano salvar(Plano plano) {
        return planoRepository.save(plano);
    }

    public Plano atualizar(Long id, Plano plano) {
        buscarPorId(id);
        plano.setId(id);
        return planoRepository.save(plano);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        planoRepository.deleteById(id);
    }
}