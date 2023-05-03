package br.com.fundatec.repository;

import br.com.fundatec.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Classe de acesso ao banco
 */

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

    Banco findBancoByCodigo(Integer codigo);

}
