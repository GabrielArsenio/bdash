package com.arsenio.bdash.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Gabriel Arsenio
 */
@XmlRootElement
@Entity
@Table(name = "funcionarios")
@SequenceGenerator(name = "funcionarios_seq", allocationSize = 1)
public class Funcionario implements Entidade {

    @Id
    @Column(name = "id_funcionario")
    @GeneratedValue(generator = "funcionarios_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "perc_comissao", precision = 8, scale = 5)
    private BigDecimal percComissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getPercComissao() {
        return percComissao;
    }

    public void setPercComissao(BigDecimal percComissao) {
        this.percComissao = percComissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
            Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(percComissao, that.percComissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, percComissao);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", percComissao='" + percComissao + '\'' +
                '}';
    }
}
