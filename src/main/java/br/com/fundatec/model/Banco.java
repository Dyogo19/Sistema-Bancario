package br.com.fundatec.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Classe utilizada para modelar os atributos do Banco no banco de dados, com os seguintes complementos:
 * id, codigo, nome, cnpj;
 */
@Entity
@Table
public class Banco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "Nome")
    private String nome;
    @Column
    private String cnpj;

    @OneToMany(mappedBy = "banco", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Agencia> agencias;

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return id == banco.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
