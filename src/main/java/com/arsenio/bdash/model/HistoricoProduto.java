package com.arsenio.bdash.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author Gabriel Arsenio
 */
@XmlRootElement
@Entity
@Table(name = "historico_produtos")
@SequenceGenerator(name = "historico_produtos_seq", allocationSize = 1)
public class HistoricoProduto {

    @Id
    @Column(name = "id_historico_produto")
    @GeneratedValue(generator = "historico_produtos_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "dt_movimentacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimentacao;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "acao", length = 80)
    private String acao;

    @Column(name = "quantidade", precision = 15, scale = 5)
    private BigDecimal quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoricoProduto that = (HistoricoProduto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataMovimentacao, that.dataMovimentacao) &&
                Objects.equals(produto, that.produto) &&
                Objects.equals(acao, that.acao) &&
                Objects.equals(quantidade, that.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataMovimentacao, produto, acao, quantidade);
    }

    @Override
    public String toString() {
        return "HistoricoProduto{" +
                "id=" + id +
                ", dataMovimentacao=" + dataMovimentacao +
                ", produto=" + produto +
                ", acao='" + acao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
