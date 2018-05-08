package com.arsenio.bdash.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
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
}
