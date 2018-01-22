package br.org.fepb.electra.repositorios;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.org.fepb.electra.modelo.InstituicaoEspirita;

public class InstituicaoEspiritaRepositorio implements Serializable {

	private static final long serialVersionUID = 63742572005567017L;

	@Inject
	private EntityManager manager;
	
	public InstituicaoEspirita pesquisarPorId(Long id) {
		return manager.find(InstituicaoEspirita.class, id);
	}
	
	public List<InstituicaoEspirita> listarTodos() {
		return manager.createQuery("from InstituicaoEspirita", InstituicaoEspirita.class).getResultList();
	}
	
	public InstituicaoEspirita salvar(InstituicaoEspirita instituicao) {
		return manager.merge(instituicao);
	}
	
	public void remover(InstituicaoEspirita instituicao) {
		instituicao = pesquisarPorId(instituicao.getId());
		manager.remove(instituicao);
	}
	
}
