package com.arsenio.bdash.resources.endpoints;

import com.arsenio.bdash.model.Funcionario;
import com.arsenio.bdash.resources.AbstractCrudResource;
import com.arsenio.bdash.services.AbstractCrudService;
import com.arsenio.bdash.services.FuncionarioService;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("funcionarios")
public class FuncionarioResource extends AbstractCrudResource<Funcionario> {

    @Inject
    private FuncionarioService service;

    @Override
    protected AbstractCrudService<Funcionario> getService() {
        return service;
    }
}
