package br.com.fundatec.controller;

import br.com.fundatec.model.Banco;
import br.com.fundatec.service.BancoService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Classe BancoController para controlar os metodos
 */

@RestController
@RequestMapping("banco")
public class BancoCtrl {

    private final BancoService bancoService;


    public BancoCtrl(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    /**
     * Metodo para criar um banco e uma agencia vinculada ao banco
     * Utilizando um metodo para verificar se o banco se encotra null
     * E verificar se ja contem uma agencia
     *
     * @param banco
     * @return banco
     */

    @PostMapping
    public Banco criar(@RequestBody Banco banco) {
        Banco Bank = bancoService.AlreadyExist(banco.getCodigo());
        if (Bank != null && Bank.getCodigo() != null) {
            throw new RuntimeException("Banco já existente");
        }
        return bancoService.criar(banco);
    }

    /**
     * Metodo para deletar um banco pelo id
     *
     * @param id
     */

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        bancoService.deletar(id);
    }

    /**
     * Metodo para editar o banco caso precise
     * Utilizando metodo para verificar se o id e igual a 0 ou nulo
     * @param banco
     * @return banco
     */

    @PutMapping
    public Banco editar(@RequestBody Banco banco, @RequestParam Integer id) {
        bancoService.pesquisar(id);
        Banco Bank = bancoService.AlreadyExist(banco.getId());
        if (Bank != null && Bank.getId() == 0) {
            throw new RuntimeException("Banco não existe");
        }
        return bancoService.editar(banco, id);
    }

    /**
     * Metodo para pesquisar um banco pelo seu id
     *
     * @param id
     * @return banco
     */

    @GetMapping("/{id}")
    public Optional<Banco> pesquisar(@PathVariable Integer id) {
        return bancoService.pesquisar(id);
    }
}
