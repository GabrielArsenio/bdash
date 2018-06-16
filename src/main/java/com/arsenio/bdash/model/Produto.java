package com.arsenio.bdash.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author gabriel.silva
 */
@Entity
@Table(name = "produtos")
@SequenceGenerator(name = "produtos_seq", allocationSize = 1)
public class Produto implements Entidade {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(generator = "produtos_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cd_barras", length = 100)
    private String codigoBarras;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @Column(name = "vlr_venda", precision = 15, scale = 5)
    private BigDecimal valorVenda;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
                Objects.equals(codigoBarras, produto.codigoBarras) &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(descricao, produto.descricao) &&
                Objects.equals(valorVenda, produto.valorVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarras, nome, descricao, valorVenda);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valorVenda=" + valorVenda +
                '}';
    }
}
