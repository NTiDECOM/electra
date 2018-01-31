package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.Bairro;
import br.org.fepb.electra.repositorios.BairroRepositorio;

@Service
public class BairroService implements Serializable {
	
	@Autowired
	private BairroRepositorio bairroRepositorio;
	
	public BairroService(){
		//vazio
	}

	public List<Bairro> listarTodos() {
		return (List<Bairro>) bairroRepositorio.findAll();
	}
	
	/*

	@Inject
	private BairroRepositorio bairroRepositorio;
	
	public List<Bairro> listarTodos() {
		return bairroRepositorio.listarTodos();
	}
	
	public Bairro buscarPorId(Long id) {
		return bairroRepositorio.pesquisarPorId(id);
	}
	
	public List<Bairro> listarBairrosByIdCidade(Long id) {
		return (List<Bairro>) bairroRepositorio.listarBairroByCidade(id);
	}

	@Transacional
	public void salvar(Bairro bairro) {
		bairroRepositorio.salvar(bairro);
	}

	@Transacional
	public void excluir(Bairro bairro) {
		bairroRepositorio.remover(bairro);
	}*/
	
}
