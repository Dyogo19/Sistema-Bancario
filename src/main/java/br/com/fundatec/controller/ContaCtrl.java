package br.com.fundatec.controller;

import br.com.fundatec.model.Conta;
import br.com.fundatec.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Classe ContaController para controlar os metodos
 */

@RestController
@RequestMapping("conta")
public class ContaCtrl {

    private final ContaService contaService;


    public ContaCtrl(ContaService contaService) {
        this.contaService = contaService;
    }

    /**
     * Metodo para criar uma conta bancaria
     * Utilizando um metodo para verificar se o numero de conta ja existe ou o numero esta igual a 0
     * @param conta
     * @return conta
     */

    @PostMapping
    public Conta criar(Conta conta) {
        Optional<Conta> accout = contaService.pesquisar(conta.getNumero());
        if (accout != null && conta.getNumero() == 0) {
            throw new RuntimeException("Coloque um número");
        }
        return contaService.criar(conta);
    }

    /**
     * Metodo para deletar uma conta pelo id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        contaService.deletar(id);
    }

    /**
     * Metodo para editar uma conta, caso seja preciso
     * @param conta
     * @return conta
     */
    @PutMapping
    public Conta editar(@RequestBody Conta conta) {
        return contaService.editar(conta);
    }

    /**
     * Metodo para pesquisar uma conta pelo seu id
     * @param id
     * @return conta
     */
    @GetMapping
    public Optional<Conta> pesquisar(Integer id) {
        return contaService.pesquisar(id);
    }
}
