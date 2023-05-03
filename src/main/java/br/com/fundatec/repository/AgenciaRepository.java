package br.com.fundatec.repository;

import br.com.fundatec.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Classe de acesso ao banco
 */

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {
    Agencia findAgenciaByNumero(Integer numero);
}
