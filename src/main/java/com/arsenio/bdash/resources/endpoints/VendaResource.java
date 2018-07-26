package com.arsenio.bdash.resources.endpoints;

import com.arsenio.bdash.model.Venda;
import com.arsenio.bdash.resources.AbstractCrudResource;
import com.arsenio.bdash.services.AbstractCrudService;
import com.arsenio.bdash.services.VendaService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("vendas")
public class VendaResource extends AbstractCrudResource<Venda> {

    @Inject
    private VendaService service;

    @Override
    protected AbstractCrudService<Venda> getService() {
        return service;
    }
}
