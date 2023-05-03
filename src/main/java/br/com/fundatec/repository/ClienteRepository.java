package br.com.fundatec.repository;

import br.com.fundatec.model.Cliente;
import br.com.fundatec.model.Conta;
import br.com.fundatec.service.ClienteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Classe de acesso ao banco
 */

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByCpf(String cpf);

}
