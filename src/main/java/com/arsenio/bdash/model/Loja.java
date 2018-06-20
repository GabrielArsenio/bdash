package com.arsenio.bdash.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * @author Gabriel Arsenio
 */
@XmlRootElement
@Entity
@Table(name = "lojas")
@SequenceGenerator(name = "lojas_seq", allocationSize = 1)
public class Loja implements Entidade {

    @Id
    @Column(name = "id_loja")
    @GeneratedValue(generator = "lojas_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "razao_social", length = 80)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
        Loja loja = (Loja) o;
        return Objects.equals(id, loja.id) &&
                Objects.equals(nome, loja.nome) &&
                Objects.equals(razaoSocial, loja.razaoSocial) &&
                Objects.equals(cnpj, loja.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, razaoSocial, cnpj);
    }

    @Override
    public String toString() {
        return "Loja{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
