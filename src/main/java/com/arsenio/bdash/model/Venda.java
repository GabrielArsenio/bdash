package com.arsenio.bdash.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Gabriel Arsenio
 */
public class Venda {

    private Long id;
    private Date data;
    private Funcionario funcionario;
    private BigDecimal valorTotal;
    private BigDecimal valorDesconto;
}
