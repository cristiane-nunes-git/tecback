package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Planos;
import br.uniesp.si.techback.repository.PlanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanosService {

    @Autowired
    private PlanosRepository planosRepository;

    public List<Planos> listarTodos() {
        return planosRepository.findAll();
    }

    public Optional<Planos> buscarPorId(Long id) {
        return planosRepository.findById(id);
    }

    public Planos salvar(Planos planos) {
        return planosRepository.save(planos);
    }

    public void deletar(Long id) {
        planosRepository.deleteById(id);
    }
}
