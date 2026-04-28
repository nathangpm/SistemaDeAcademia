package fiap.com.br.SistemaDeAcademia.controller;

import fiap.com.br.SistemaDeAcademia.model.Aluno;
import fiap.com.br.SistemaDeAcademia.projection.AlunoProjection;
import fiap.com.br.SistemaDeAcademia.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Aluno>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(alunoService.buscarPorNome(nome));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Aluno> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(alunoService.buscarPorCpf(cpf));
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Aluno>> listarPaginado(
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(alunoService.listarPaginado(pageable));
    }

    @GetMapping("/buscar/paginado")
    public ResponseEntity<Page<Aluno>> buscarPorNomePaginado(
            @RequestParam String nome,
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(alunoService.buscarPorNomePaginado(nome, pageable));
    }

    @GetMapping("/projection")
    public ResponseEntity<List<AlunoProjection>> listarProjection() {
        return ResponseEntity.ok(alunoService.listarProjection());
    }

    @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody @Valid Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
        return ResponseEntity.ok(alunoService.atualizar(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}