package br.org.fepb.electra.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.fepb.electra.daos.InstituicaoEspiritaRepositorio;
import br.org.fepb.electra.models.InstituicaoEspirita;
import br.org.fepb.electra.util.Transacional;

public class InstituicaoEspiritaService implements Serializable {

	private static final long serialVersionUID = 8460255497365537489L;

	@Inject
	private InstituicaoEspiritaRepositorio instituicaoRepositorio;
	
	public List<InstituicaoEspirita> listarTodos() {
		return instituicaoRepositorio.listarTodos();
	}

	@Transacional
	public void salvar(InstituicaoEspirita evangelizador) {
		instituicaoRepositorio.salvar(evangelizador);
	}

	@Transacional
	public void excluir(InstituicaoEspirita evangelizador) {
		instituicaoRepositorio.remover(evangelizador);
	}

}
