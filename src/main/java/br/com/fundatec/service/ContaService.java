package br.com.fundatec.service;

import br.com.fundatec.model.Conta;
import br.com.fundatec.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe ContaService utilizada para criar uma conta, para ser utilizada pelo cliente no banco
 * @see ContaRepository
 */

@Service
public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;

    }

    /**
     * Metodo para criar uma conta bancaria
     *
     * @param conta
     * @return conta @{@link Conta}
     */
    public Conta criar(Conta conta) {
        return repository.save(conta);
    }

    /**
     * Metodo para deletar uma conta pelo id
     * @param id
     */
    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Metodo para editar uma conta, caso seja preciso
     * @param conta
     * @return conta @{@link Conta}
     */
    public Conta editar(Conta conta) {
        return repository.save(conta);
    }

    /**
     * Metodo para pesquisar uma conta pelo seu id
     * @param id
     * @return conta @{@link Conta}
     */
    public Optional<Conta> pesquisar(Integer id) {
        return repository.findById(id);
    }
}
