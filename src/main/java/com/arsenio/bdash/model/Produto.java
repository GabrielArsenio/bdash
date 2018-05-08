package com.arsenio.bdash.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gabriel.silva
 */
@XmlRootElement
@Entity
@Table(name = "produtos")
@SequenceGenerator(name = "produtos_seq", allocationSize = 1)
public class Produto {

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
}
