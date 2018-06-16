package com.arsenio.bdash.resources.endpoints;

import com.arsenio.bdash.model.Produto;
import com.arsenio.bdash.resources.AbstractCrudResource;
import com.arsenio.bdash.services.AbstractCrudService;
import com.arsenio.bdash.services.ProdutoService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("produtos")
public class ProdutoResource extends AbstractCrudResource<Produto> {

    @Inject
    private ProdutoService service;

    @Override
    protected AbstractCrudService<Produto> getService() {
        return service;
    }
}
