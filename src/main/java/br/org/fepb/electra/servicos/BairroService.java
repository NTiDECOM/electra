package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.Bairro;
import br.org.fepb.electra.repositorios.BairroRepositorio;

@Service
public class BairroService implements Serializable, ServiceInterface<Bairro> {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private BairroRepositorio bairroRepositorio;
	
	public BairroService(){
		//vazio
	}

	public List<Bairro> listarTodos() {
		return (List<Bairro>) bairroRepositorio.findAll();
	}

	@Override
	public Bairro salvar(Bairro e) {
		return bairroRepositorio.save(e);
	}

	@Override
	public void excluir(Bairro e) {
		bairroRepositorio.delete(e);
		
	}
	
	
}
