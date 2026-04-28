package fiap.com.br.SistemaDeAcademia.controller;

import fiap.com.br.SistemaDeAcademia.model.Treino;
import fiap.com.br.SistemaDeAcademia.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;

    @GetMapping
    public ResponseEntity<List<Treino>> listarTodos() {
        return ResponseEntity.ok(treinoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treino> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(treinoService.buscarPorId(id));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Treino>> buscarPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(treinoService.buscarPorAluno(alunoId));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Treino>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(treinoService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Treino> salvar(@RequestBody @Valid Treino treino) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treinoService.salvar(treino));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizar(@PathVariable Long id, @RequestBody @Valid Treino treino) {
        return ResponseEntity.ok(treinoService.atualizar(id, treino));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        treinoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}