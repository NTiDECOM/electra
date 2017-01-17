package br.org.fepb.electra.services;

import java.io.Serializable;

import javax.inject.Inject;

import br.org.fepb.electra.daos.EmpresaRepositorio;
import br.org.fepb.electra.models.Empresa;
import br.org.fepb.electra.util.Transacional;

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