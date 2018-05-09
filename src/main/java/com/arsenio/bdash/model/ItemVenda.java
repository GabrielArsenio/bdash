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
@Table(name = "itens_venda")
@SequenceGenerator(name = "itens_venda_seq", allocationSize = 1)
public class ItemVenda {

    @Id
    @Column(name = "id_item_venda")
    @GeneratedValue(generator = "itens_venda_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "sequencia", length = 8)
    private Integer sequencia;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade", precision = 15, scale = 5)
    private BigDecimal quantidade;

    @Column(name = "vlr_total", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Column(name = "vlr_desconto", precision = 15, scale = 5)
    private BigDecimal valorDesconto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return Objects.equals(id, itemVenda.id) &&
                Objects.equals(sequencia, itemVenda.sequencia) &&
                Objects.equals(produto, itemVenda.produto) &&
                Objects.equals(quantidade, itemVenda.quantidade) &&
                Objects.equals(valorTotal, itemVenda.valorTotal) &&
                Objects.equals(valorDesconto, itemVenda.valorDesconto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sequencia, produto, quantidade, valorTotal, valorDesconto);
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "id=" + id +
                ", sequencia=" + sequencia +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorTotal=" + valorTotal +
                ", valorDesconto=" + valorDesconto +
                '}';
    }
}
