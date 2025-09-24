package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.service.PlanosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@RequiredArgsConstructor
public class PlanosController {

    private final PlanosService planosService;

    @GetMapping
    public List<Plano> listar() {
        return planosService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(planosService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Plano> criar(@Valid @RequestBody Plano plano) {
        Plano planoSalvo = planosService.salvar(plano);
        return ResponseEntity.ok(planoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> atualizar(@PathVariable Long id, @Valid @RequestBody Plano plano) {
        try {
            Plano planoAtualizado = planosService.atualizar(id, plano);
            return ResponseEntity.ok(planoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            planosService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
