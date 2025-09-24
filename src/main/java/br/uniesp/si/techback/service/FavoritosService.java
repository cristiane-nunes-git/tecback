package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Favoritos;
import br.uniesp.si.techback.repository.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    public List<Favoritos> listarTodos() {
        return favoritosRepository.findAll();
    }

    public Optional<Favoritos> buscarPorId(Long id) {
        return favoritosRepository.findById(id);
    }

    public Favoritos salvar(Favoritos favoritos) {
        return favoritosRepository.save(favoritos);
    }

    public void deletar(Long id) {
        favoritosRepository.deleteById(id);
    }
}
