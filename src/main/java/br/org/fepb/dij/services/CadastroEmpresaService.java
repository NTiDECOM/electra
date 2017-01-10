package br.org.fepb.dij.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.org.fepb.dij.daos.EmpresaRepositorio;
import br.org.fepb.dij.models.Empresa;
import br.org.fepb.dij.util.Transacional;

public class CadastroEmpresaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepositorio empresas;
	
	@Transacional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}
	
	@Transacional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}

}