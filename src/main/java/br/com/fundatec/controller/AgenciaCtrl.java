package br.com.fundatec.controller;


import br.com.fundatec.model.Agencia;
import br.com.fundatec.model.Banco;
import br.com.fundatec.model.Conta;
import br.com.fundatec.service.AgenciaService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Classe AgenciaController para controlar os metodos
 */

@Tag(name = "Agencia")
@RestController
@RequestMapping("agencia")
public class AgenciaCtrl {

    private final AgenciaService agenciaService;

    public AgenciaCtrl(AgenciaService agenciaService) {
        this.agenciaService = agenciaService;
    }

    /**
     * Metodo para criar a agencia e verificar se ja existe o numero de conta ou esta nulo
     *
     * @param agencia
     * @return agencia
     */

    @PostMapping
    public Agencia criar(Agencia agencia) {
        Agencia Agencias = agenciaService.AlreadyExist(agencia.getNumero());
        if (Agencias != null && Agencias.getNumero() != null) {
            throw new RuntimeException("Agencia já existente");
        }
        return agenciaService.criar(agencia);
    }

    /**
     * Metodo para deletar a agencia pelo id
     *
     * @param id
     */

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        agenciaService.deletar(id);
    }

    /**
     * Metodo para editar as caracteristicas da agencia, caso precise
     * Utilizando outro metodo para verificar se o id nao e 0
     *
     * @param agencia
     * @return agencia
     */

    @PutMapping
    public Agencia editar(@RequestBody Agencia agencia, Integer id) {
        agenciaService.pesquisar(id);
        Agencia Agenc = agenciaService.AlreadyExist(agencia.getId());
        if (Agenc != null && Agenc.getId() == 0) {
            throw new RuntimeException("Agencia não existe");
        }
        return agenciaService.editar(agencia, id);
    }

    /**
     * Metodo para pesquisar uma agencia pelo seu id
     *
     * @param id
     * @return agencia
     */

    @GetMapping("/{id}")
    public Optional<Agencia> pesquisar(@PathVariable Integer id) {
        return agenciaService.pesquisar(id);
    }
}
