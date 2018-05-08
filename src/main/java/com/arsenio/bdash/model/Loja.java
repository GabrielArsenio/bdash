package com.arsenio.bdash.model;

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
 * @author Gabriel Arsenio
 */
@XmlRootElement
@Entity
@Table(name = "lojas")
@SequenceGenerator(name = "lojas_seq", allocationSize = 1)
public class Loja {

    @Id
    @Column(name = "id_loja")
    @GeneratedValue(generator = "lojas_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "razao_social", length = 80)
    private String razaoSocial;

    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @Column(name = "cep", length = 10)
    private String cep;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "bairro", length = 80)
    private String bairro;

    @Column(name = "cidade", length = 80)
    private String cidade;

    @Column(name = "uf", length = 2)
    private String uf;
}
