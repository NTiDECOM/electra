package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.Sala;
import br.org.fepb.electra.repositorios.SalaRepositorio;
import br.org.fepb.electra.util.Transacional;

@Service
public class SalaService implements Serializable {

	private static final long serialVersionUID = 5214699266012705925L;

	@Autowired
	private SalaRepositorio salaRepositorio;
	
	public List<Sala> listarTodos() {
		return (List<Sala>) salaRepositorio.findAll();
	}
	
	public Sala listarById(Long id) {
		return salaRepositorio.findOne(id);
	}
	
	public List<Sala> listarByInstituicao(Long idInstituicao) {
		return salaRepositorio.findAllByInstituicao(idInstituicao);
	}

	@Transacional
	public void salvar(Sala sala) {
		salaRepositorio.save(sala);
	}

	@Transacional
	public void excluir(Sala sala) {
		salaRepositorio.delete(sala);
	}
	
}
