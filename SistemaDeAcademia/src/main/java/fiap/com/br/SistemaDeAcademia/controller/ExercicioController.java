package fiap.com.br.SistemaDeAcademia.controller;

import fiap.com.br.SistemaDeAcademia.model.Exercicio;
import fiap.com.br.SistemaDeAcademia.service.ExercicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<Exercicio>> listarTodos() {
        return ResponseEntity.ok(exercicioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(exercicioService.buscarPorId(id));
    }

    @GetMapping("/grupo-muscular/{grupoMuscular}")
    public ResponseEntity<List<Exercicio>> buscarPorGrupoMuscular(@PathVariable String grupoMuscular) {
        return ResponseEntity.ok(exercicioService.buscarPorGrupoMuscular(grupoMuscular));
    }

    @GetMapping("/treino/{treinoId}")
    public ResponseEntity<List<Exercicio>> buscarPorTreino(@PathVariable Long treinoId) {
        return ResponseEntity.ok(exercicioService.buscarPorTreino(treinoId));
    }

    @PostMapping
    public ResponseEntity<Exercicio> salvar(@RequestBody @Valid Exercicio exercicio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exercicioService.salvar(exercicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long id, @RequestBody @Valid Exercicio exercicio) {
        return ResponseEntity.ok(exercicioService.atualizar(id, exercicio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        exercicioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}