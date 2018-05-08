package com.arsenio.bdash.model;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
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
}
