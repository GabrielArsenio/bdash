package com.arsenio.bdash.model;

import java.math.BigDecimal;

/**
 *
 * @author Gabriel Arsenio
 */
public class ItemVenda {

    private Long id;
    private Integer sequencia;
    private Produto produto;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
}
