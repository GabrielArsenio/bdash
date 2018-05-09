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
@Table(name = "estoque")
@SequenceGenerator(name = "estoque_seq", allocationSize = 1)
public class Estoque {

    @Id
    @Column(name = "id_estoque")
    @GeneratedValue(generator = "estoque_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade", precision = 15, scale = 5)
    private BigDecimal quantidade;

    @Column(name = "qtd_minima", precision = 15, scale = 5)
    private BigDecimal quantidadeMinima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(BigDecimal quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id) &&
                Objects.equals(produto, estoque.produto) &&
                Objects.equals(quantidade, estoque.quantidade) &&
                Objects.equals(quantidadeMinima, estoque.quantidadeMinima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, produto, quantidade, quantidadeMinima);
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", quantidadeMinima=" + quantidadeMinima +
                '}';
    }
}
