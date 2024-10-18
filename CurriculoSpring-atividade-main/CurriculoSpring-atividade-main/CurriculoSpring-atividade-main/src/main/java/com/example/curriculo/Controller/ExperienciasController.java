package com.example.curriculo.Controller;

import com.example.curriculo.Model.Experiencias;
import com.example.curriculo.Service.ExperienciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencias")
public class ExperienciasController {

    @Autowired
    private ExperienciasService experienciasService;

    @GetMapping
    public List<Experiencias> getAllExperiencias() {
        return experienciasService.getAllExperiencias();
    }

    @GetMapping("/{id}")
    public Experiencias getExperienciasById(@PathVariable Long id) {
        return experienciasService.getExperienciasById(id).orElse(null);
    }

    @PostMapping
    public Experiencias criarExperiencias(@RequestBody Experiencias experiencias) {
        return experienciasService.criarExperiencias(experiencias);
    }

    @PutMapping("/{id}")
    public Experiencias atualizarExperiencias(@PathVariable Long id, @RequestBody Experiencias experienciasDetails) throws Exception {
        return experienciasService.atualizarExperiencias(id, experienciasDetails);
    }

    @DeleteMapping("/{id}")
    public void deletarExperiencias(@PathVariable Long id) {
        experienciasService.deletarExperiencias(id);
//Controlle = gerencia o envio de informações enviadas ao banco
//Controller = cria as URLs
    }
}
