package com.arsenio.bdash.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Gabriel Arsenio
 */
public class HistoricoProduto {

    private Long id;
    private Date data;
    private Produto produto;
    private String acao;
    private BigDecimal quantidade;
}
