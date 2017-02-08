package br.org.fepb.electra.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.org.fepb.electra.models.Evangelizador;

public class EvangelizadorRepositorio implements Serializable {

	private static final long serialVersionUID = 4230391055830241930L;

	@Inject
	private EntityManager manager;
	
	public Evangelizador pesquisarPorId(Long id) {
		return manager.find(Evangelizador.class, id);
	}
	
	public List<Evangelizador> listarTodos() {
		return manager.createQuery("from Evangelizador", Evangelizador.class).getResultList();
	}
	
	public Evangelizador salvar(Evangelizador evangelizador) {
		return manager.merge(evangelizador);
	}
	
	public void remover(Evangelizador evangelizador) {
		evangelizador = pesquisarPorId(evangelizador.getId());
		manager.remove(evangelizador);
	}
	
}
