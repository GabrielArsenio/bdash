package com.arsenio.bdash.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @author Gabriel Arsenio
 */
@XmlRootElement
@Entity
@Table(name = "vendas")
@SequenceGenerator(name = "vendas_seq", allocationSize = 1)
public class Venda {

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
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id) &&
                Objects.equals(dataVenda, venda.dataVenda) &&
                Objects.equals(funcionario, venda.funcionario) &&
                Objects.equals(valorTotal, venda.valorTotal) &&
                Objects.equals(valorDesconto, venda.valorDesconto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataVenda, funcionario, valorTotal, valorDesconto);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", dataVenda=" + dataVenda +
                ", funcionario=" + funcionario +
                ", valorTotal=" + valorTotal +
                ", valorDesconto=" + valorDesconto +
                '}';
    }
}
