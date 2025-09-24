package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Favorito;
import br.uniesp.si.techback.service.FavoritosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
@RequiredArgsConstructor
public class FavoritosController {

    private final FavoritosService favoritosService;

    @GetMapping
    public List<Favorito> listar() {
        return favoritosService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(favoritosService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Favorito> criar(@Valid @RequestBody Favorito favorito) {
        Favorito favoritoSalvo = favoritosService.salvar(favorito);
        return ResponseEntity.ok(favoritoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorito> atualizar(@PathVariable Long id, @Valid @RequestBody Favorito favorito) {
        try {
            Favorito favoritoAtualizado = favoritosService.atualizar(id, favorito);
            return ResponseEntity.ok(favoritoAtualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            favoritosService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
