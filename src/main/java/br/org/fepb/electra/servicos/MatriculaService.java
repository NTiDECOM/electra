package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.org.fepb.electra.modelo.Matricula;
import br.org.fepb.electra.repositorios.MatriculaRepositorio;
import br.org.fepb.electra.util.Transacional;

public class MatriculaService implements Serializable {
	
	private static final long serialVersionUID = -4802660230220768541L;
	
	@Inject
	private MatriculaRepositorio matriculaRepositorio;

	@Transacional
	public Matricula salvar(Matricula matricula) {
		return matriculaRepositorio.salvar(matricula);
	}

	@Transacional
	public void excluir(Matricula matricula) {
		matriculaRepositorio.remover(matricula);
	}
	
	public List<Matricula> listarTodos(){
		return matriculaRepositorio.listarTodos();
	}

}
