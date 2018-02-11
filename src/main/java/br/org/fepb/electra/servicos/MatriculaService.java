package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.Matricula;
import br.org.fepb.electra.repositorios.MatriculaRepositorio;
import br.org.fepb.electra.util.Transacional;

@Service
public class MatriculaService implements Serializable, ServiceInterface<Matricula> {
	
	private static final long serialVersionUID = -4802660230220768541L;
	
	@Autowired
	private MatriculaRepositorio matriculaRepositorio;

	@Transacional
	public Matricula salvar(Matricula matricula) {
		return matriculaRepositorio.save(matricula);
	}

	@Transacional
	public void excluir(Matricula matricula) {
		matriculaRepositorio.delete(matricula);
	}
	
	public List<Matricula> listarTodos(){
		return (List<Matricula>) matriculaRepositorio.findAll();
	}

    public List<Matricula> buscarPorDataNasc(String textoPesquisa) {
		return matriculaRepositorio.buscarPorDataNasc(textoPesquisa);
    }
}
