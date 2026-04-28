package fiap.com.br.SistemaDeAcademia.controller;

import fiap.com.br.SistemaDeAcademia.model.Matricula;
import fiap.com.br.SistemaDeAcademia.model.Matricula.StatusMatricula;
import fiap.com.br.SistemaDeAcademia.service.MatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> listarTodos() {
        return ResponseEntity.ok(matriculaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(matriculaService.buscarPorId(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Matricula>> buscarPorStatus(@PathVariable StatusMatricula status) {
        return ResponseEntity.ok(matriculaService.buscarPorStatus(status));
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Matricula>> buscarPorAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(matriculaService.buscarPorAluno(alunoId));
    }

    @GetMapping("/plano/{planoId}")
    public ResponseEntity<List<Matricula>> buscarPorPlano(@PathVariable Long planoId) {
        return ResponseEntity.ok(matriculaService.buscarPorPlano(planoId));
    }

    @GetMapping("/vencidas")
    public ResponseEntity<List<Matricula>> buscarVencidas() {
        return ResponseEntity.ok(matriculaService.buscarVencidas());
    }

    @PostMapping
    public ResponseEntity<Matricula> salvar(@RequestBody @Valid Matricula matricula) {
        return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.salvar(matricula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> atualizar(@PathVariable Long id, @RequestBody @Valid Matricula matricula) {
        return ResponseEntity.ok(matriculaService.atualizar(id, matricula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        matriculaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}