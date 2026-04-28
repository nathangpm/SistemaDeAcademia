package fiap.com.br.SistemaDeAcademia.controller;

import fiap.com.br.SistemaDeAcademia.model.Plano;
import fiap.com.br.SistemaDeAcademia.service.PlanoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<Plano>> listarTodos() {
        return ResponseEntity.ok(planoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(planoService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Plano>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(planoService.buscarPorNome(nome));
    }

    @GetMapping("/faixa-preco")
    public ResponseEntity<List<Plano>> buscarPorFaixa(
            @RequestParam Double precoMin,
            @RequestParam Double precoMax) {
        return ResponseEntity.ok(planoService.buscarPorFaixa(precoMin, precoMax));
    }

    @PostMapping
    public ResponseEntity<Plano> salvar(@RequestBody @Valid Plano plano) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planoService.salvar(plano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> atualizar(@PathVariable Long id, @RequestBody @Valid Plano plano) {
        return ResponseEntity.ok(planoService.atualizar(id, plano));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        planoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}