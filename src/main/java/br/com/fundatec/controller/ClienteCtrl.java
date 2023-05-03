package br.com.fundatec.controller;

import br.com.fundatec.model.Cliente;
import br.com.fundatec.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Classe ClienteController para controlar os metodos
 */

@RestController
@RequestMapping("cliente")
public class ClienteCtrl {

    private final ClienteService clienteService;

    public ClienteCtrl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Metodo para criar o cliete
     *
     * @param cliente
     * @return cliente
     */

    @PostMapping
    public Cliente criar(Cliente cliente) {
        return clienteService.criar(cliente);
    }

    /**
     * Metodo para deletar o cliente pelo id
     *
     * @param id
     */

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        clienteService.deletar(id);
    }

    /**
     * Metodo para editar o cliente
     *
     * @param cliente
     * @return cliente
     */

    @PutMapping
    public Cliente editar(@RequestBody Cliente cliente) {
        return clienteService.editar(cliente);
    }

    /**
     * Metodo para pesquisar o cliente pelo seu id
     *
     * @param id
     * @return cliente
     */

    @GetMapping("/{id}")
    public Optional<Cliente> pesquisar(@PathVariable Integer id) {
        return clienteService.pesquisar(id);
    }

    /**
     * Metodo para fazer uma pesquisa pelo "CPF" do cliente desejado
     *
     * @param cpf
     * @return cliente
     */

    @GetMapping("busca-cpf")
    public Cliente pesquisarPorCpf(@RequestParam String cpf) {
        return clienteService.pesquisarPorCpf(cpf);
    }
}
