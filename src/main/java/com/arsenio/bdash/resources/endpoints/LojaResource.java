package com.arsenio.bdash.resources.endpoints;

import com.arsenio.bdash.model.Loja;
import com.arsenio.bdash.resources.AbstractCrudResource;
import com.arsenio.bdash.services.AbstractCrudService;
import com.arsenio.bdash.services.LojaService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("Lojas")
public class LojaResource extends AbstractCrudResource<Loja> {

    @Inject
    private LojaService service;

    @Override
    protected AbstractCrudService<Loja> getService() {
        return service;
    }
}
