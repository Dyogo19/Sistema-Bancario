package br.com.fundatec.service;

import br.com.fundatec.model.Agencia;
import br.com.fundatec.repository.AgenciaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe AgenciaService utilizada para criar uma agencia e vincular a um banco
 *
 * @see AgenciaRepository
 */
@Service
public class AgenciaService extends RuntimeException {
    private final AgenciaRepository repository;


    public AgenciaService(AgenciaRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo para criar a agencia
     *
     * @param agencia
     * @return agencia @{@link Agencia}
     */
    public Agencia criar(Agencia agencia) {
        return repository.save(agencia);
    }

    /**
     * Metodo para deletar a agencia pelo id
     *
     * @param id
     */
    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Metodo para editar as caracteristicas da agencia, caso precise
     *
     * @param agencia
     * @return agencia @{@link Agencia}
     */
    public Agencia editar(Agencia agencia, Integer id) {
        return repository.save(agencia);
    }

    /**
     * Metodo para validar se o numero da conta ja existe
     *
     * @param numero
     * @return true ou false
     */
    public Agencia AlreadyExist(Integer numero) {
        return repository.findAgenciaByNumero(numero);
    }

    /**
     * Metodo para pesquisar uma agencia pelo seu id
     *
     * @param id
     * @return agencia @{@link Agencia}
     */
    public Optional<Agencia> pesquisar(Integer id) {
        return repository.findById(id);
    }

}

