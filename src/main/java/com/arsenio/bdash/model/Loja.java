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
public class Loja {

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

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "bairro", length = 80)
    private String bairro;

    @Column(name = "cidade", length = 80)
    private String cidade;

    @Column(name = "uf", length = 2)
    private String uf;

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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return Objects.equals(id, loja.id) &&
                Objects.equals(nome, loja.nome) &&
                Objects.equals(razaoSocial, loja.razaoSocial) &&
                Objects.equals(cnpj, loja.cnpj) &&
                Objects.equals(cep, loja.cep) &&
                Objects.equals(endereco, loja.endereco) &&
                Objects.equals(bairro, loja.bairro) &&
                Objects.equals(cidade, loja.cidade) &&
                Objects.equals(uf, loja.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, razaoSocial, cnpj, cep, endereco, bairro, cidade, uf);
    }

    @Override
    public String toString() {
        return "Loja{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
