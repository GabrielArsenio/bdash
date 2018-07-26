package com.arsenio.bdash.services;


import com.arsenio.bdash.model.Venda;
import com.arsenio.bdash.util.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class VendaService extends AbstractCrudService<Venda> {

    @Inject
    private GenericDao<Venda> dao;

    @Override
    protected GenericDao<Venda> getDao() {
        return dao;
    }
}
