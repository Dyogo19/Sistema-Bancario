package br.com.fundatec.service;

import br.com.fundatec.model.Cliente;
import br.com.fundatec.repository.ClienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe ClienteService utilizada para criar um cliente e disponibilizar uma pesquisa por "CPF"
 *
 * @see ClienteRepository
 */

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ObjectMapper objectMapper;


    public ClienteService(ClienteRepository repository, ObjectMapper objectMapper) {
        this.clienteRepository = repository;
        this.objectMapper = objectMapper;
    }

    /**
     * Metodo para criar o cliete
     *
     * @param cliente
     * @return cliente @{@link Cliente}
     */
    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Metodo para deletar o cliente pelo id
     *
     * @param id
     */
    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }

    /**
     * Metodo para editar o cliente
     *
     * @param cliente
     * @return cliente @{@link Cliente}
     */
    public Cliente editar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Metodo para pesquisar o cliente pelo seu id
     *
     * @param id
     * @return cliente @{@link Cliente}
     */
    public Optional<Cliente> pesquisar(Integer id) {
        return clienteRepository.findById(id);
    }

    /**
     * Metodo para fazer uma pesquisa pelo "CPF" do cliente desejado
     *
     * @param cpf
     * @return cliente @{@link Cliente}
     */
    public Cliente pesquisarPorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);

        if (cliente == null) {
            return null;
        }
        Cliente clienteRetorno = objectMapper.convertValue(cliente, Cliente.class);


        return clienteRetorno;
    }

}
