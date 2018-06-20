package com.arsenio.bdash.services;


import com.arsenio.bdash.model.Loja;
import com.arsenio.bdash.util.GenericDao;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LojaService extends AbstractCrudService<Loja> {

    @Inject
    private GenericDao<Loja> dao;

    @Override
    protected GenericDao<Loja> getDao() {
        return dao;
    }
}
