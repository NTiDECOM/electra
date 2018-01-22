package br.org.fepb.electra.repositorios;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.org.fepb.electra.modelo.Evangelizando;

public class EvangelizandoRepositorio implements Serializable {

	private static final long serialVersionUID = 5267511272706247117L;

	@Inject
	private EntityManager manager;
	
	public Evangelizando pesquisarPorId(Long id) {
		return manager.find(Evangelizando.class, id);
	}
	
	public List<Evangelizando> listarTodos() {
		return manager.createQuery("from Evangelizando", Evangelizando.class).getResultList();
	}
	
	public Evangelizando salvar(Evangelizando evangelizando) {
		return manager.merge(evangelizando);
	}
	
	public void remover(Evangelizando evangelizando) {
		evangelizando = pesquisarPorId(evangelizando.getId());
		manager.remove(evangelizando);
	}

	
}
