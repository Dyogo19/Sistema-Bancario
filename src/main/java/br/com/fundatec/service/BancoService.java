package br.com.fundatec.service;

import br.com.fundatec.model.Banco;
import br.com.fundatec.repository.BancoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe BancoService utilizada para criar um banco e vincular a uma agencia
 * @see BancoRepository
 */
@Service
public class BancoService {

    private final BancoRepository bancoRepository;

    public BancoService(BancoRepository repository) {
        this.bancoRepository = repository;
    }

    /**
     * Metodo para criar um banco e uma agencia vinculada ao banco
     * Utilizando um metodo para verificar se o banco se encotra null
     * E verificar se ja contem uma agencia
     * @param banco
     * @return banco @{@link  Banco}
     */
    public Banco criar(Banco banco){

        if(banco == null) {
            throw  new IllegalArgumentException();
        }

        if(banco.getAgencias() != null) {
            banco.getAgencias().stream().forEach(a -> a.setBanco(banco));
        }

        return bancoRepository.save(banco);
    }

    /**
     * Metodo para deletar um banco pelo id
     * @param id
     */
    public void deletar(Integer id) {
        bancoRepository.deleteById(id);
    }

    /**
     * Metodo para validar se o codigo do banco ja existe
     * @param codigo
     * @return true ou false
     */
    public Banco AlreadyExist(Integer codigo) {
        return bancoRepository.findBancoByCodigo(codigo);
    }

    /**
     * Metodo para editar o banco caso precise
     * @param banco
     * @return banco @{@link  Banco}
     */
    public Banco editar(Banco banco, Integer id) {
      return bancoRepository.save(banco);
    }

    /**
     * Metodo para pesquisar um banco pelo seu id
     *
     * @param id
     * @return banco @{@link  Banco}
     */
    public Optional<Banco> pesquisar(Integer id) {
        return bancoRepository.findById(id);
    }
}
