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
}
