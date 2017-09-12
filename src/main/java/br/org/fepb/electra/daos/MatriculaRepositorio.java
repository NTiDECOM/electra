package br.org.fepb.electra.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.org.fepb.electra.models.Matricula;

public class MatriculaRepositorio implements Serializable {

	private static final long serialVersionUID = 4230391055830241930L;

	@Inject
	private EntityManager manager;
	
	public Matricula pesquisarPorId(Long id) {
		return manager.find(Matricula.class, id);
	}
	
	public List<Matricula> listarTodos() {
		return manager.createQuery("from Matricula", Matricula.class).getResultList();
	}
	
	public Matricula salvar(Matricula matricula) {
		return manager.merge(matricula);
	}
	
	public void remover(Matricula matricula) {
		matricula = pesquisarPorId(matricula.getId());
		manager.remove(matricula);
	}
	
}
