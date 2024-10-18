package com.example.curriculo.Service;

import com.example.curriculo.Model.Experiencias;
import com.example.curriculo.Repository.ExperienciasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciasService{

    @Autowired
    private ExperienciasRepository experienciasRepository;

    public List<Experiencias> getAllExperiencias() {
        return experienciasRepository.findAll();
    }

    public Optional<Experiencias> getExperienciasById(Long id) {
        return experienciasRepositoryRepository.findById(id);
    }

    @Transactional
    public Experiencias criarExperiencias(Experiencias experiencias) {
        return experienciasRepository.save(experiencias);
    }

    @Transactional
    public Experiencias atualizarExperiencias(Long id, Experiencias experienciasDetails) throws Exception {
        Optional<Experiencias> Experiencias = experienciasRepository.findById(id);

        if (Experiencias.isPresent()) {
            Experiencias experiencias = Experiencias.get();

            experiencias.setNome(experienciasDetails.getNome());
            experiencias.setTempo(experienciasDetails.getTempo());
            return ExperienciasRepository.save(experiencias);
        }
        else {
            throw new Exception("Experiencias não encontrado com o id: " + id);
        }
    }
    @Transactional
    public void deletarExperiencias(@PathVariable Long id) {
        Optional<Experiencias> optionalExperiencias = experienciasRepository.findById(id);

        if (optionalExperiencias.isPresent()) {
            Experiencias experiencias= optionalExperiencias.get();
            experienciasRepository.delete(experiencias);
        }
    }

}