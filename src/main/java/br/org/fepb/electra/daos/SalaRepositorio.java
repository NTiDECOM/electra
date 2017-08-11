package br.org.fepb.electra.daos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.org.fepb.electra.models.Sala;

public class SalaRepositorio implements Serializable {

	private static final long serialVersionUID = 5459273955629068174L;

	@Inject
	private EntityManager manager;
	
	public Sala pesquisarPorId(Long id) {
		return manager.find(Sala.class, id);
	}
	
	public List<Sala> listarTodos() {
		return manager.createQuery("from Sala", Sala.class).getResultList();
	}
	
	public List<Sala> listarByInstituicao(Long idInstituicao) {
		return manager.createQuery("from Sala where idInstituicao = :idInstituicao", Sala.class)
				.setParameter("idInstituicao", idInstituicao).getResultList();
	}
	
	public Sala salvar(Sala sala) {
		return manager.merge(sala);
	}
	
	public void remover(Sala sala) {
		sala = pesquisarPorId(sala.getId());
		manager.remove(sala);
	}
	
}
