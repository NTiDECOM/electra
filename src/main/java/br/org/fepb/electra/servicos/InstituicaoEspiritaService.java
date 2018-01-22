package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.repositorios.InstituicaoEspiritaRepositorio;
import br.org.fepb.electra.util.Transacional;

public class InstituicaoEspiritaService implements Serializable {

	private static final long serialVersionUID = 8460255497365537489L;

	@Inject
	private InstituicaoEspiritaRepositorio instituicaoRepositorio;
	
	public InstituicaoEspirita pesquisarPorId(Long id) {
		return instituicaoRepositorio.pesquisarPorId(id);
	}
	
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
