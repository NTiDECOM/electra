package br.org.fepb.electra.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.fepb.electra.daos.SalaRepositorio;
import br.org.fepb.electra.models.Sala;
import br.org.fepb.electra.util.Transacional;

public class SalaService implements Serializable {

	private static final long serialVersionUID = 5214699266012705925L;

	@Inject
	private SalaRepositorio salaRepositorio;
	
	public List<Sala> listarTodos() {
		return salaRepositorio.listarTodos();
	}
	
	public Sala listarById(Long id) {
		return salaRepositorio.pesquisarPorId(id);
	}
	
	public List<Sala> listarByInstituicao(Long idInstituicao) {
		return salaRepositorio.listarByInstituicao(idInstituicao);
	}

	@Transacional
	public void salvar(Sala sala) {
		salaRepositorio.salvar(sala);
	}

	@Transacional
	public void excluir(Sala sala) {
		salaRepositorio.remover(sala);
	}
	
}
