package com.arsenio.bdash.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Gabriel Arsenio
 */
@XmlRootElement
@Entity
@Table(name = "vendas")
@SequenceGenerator(name = "vendas_seq", allocationSize = 1)
public class Venda implements Entidade {

    @Id
    @Column(name = "id_venda")
    @GeneratedValue(generator = "vendas_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "dt_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja loja;

    @Column(name = "vlr_total", precision = 15, scale = 5)
    private BigDecimal valorTotal;

    @Column(name = "vlr_desconto", precision = 15, scale = 5)
    private BigDecimal valorDesconto;

    @JoinColumn(name = "id_venda")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemVenda> itens;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
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

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id) &&
                Objects.equals(dataVenda, venda.dataVenda) &&
                Objects.equals(funcionario, venda.funcionario) &&
                Objects.equals(loja, venda.loja) &&
                Objects.equals(valorTotal, venda.valorTotal) &&
                Objects.equals(valorDesconto, venda.valorDesconto) &&
                Objects.equals(itens, venda.itens);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dataVenda, funcionario, loja, valorTotal, valorDesconto, itens);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", dataVenda=" + dataVenda +
                ", funcionario=" + funcionario +
                ", loja=" + loja +
                ", valorTotal=" + valorTotal +
                ", valorDesconto=" + valorDesconto +
                ", itens=" + itens +
                '}';
    }
}
