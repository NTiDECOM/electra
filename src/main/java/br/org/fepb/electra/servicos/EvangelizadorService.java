package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.Evangelizador;
import br.org.fepb.electra.repositorios.EvangelizadorRepositorio;
import br.org.fepb.electra.util.Transacional;

@Service
public class EvangelizadorService implements Serializable {
	
	private static final long serialVersionUID = -4802660230220768541L;
	
	//@Inject
	@Autowired
	private EvangelizadorRepositorio evangelizadorRepositorio;

	@Transacional
	public void salvar(Evangelizador evangelizador) {
		evangelizador.setDataCadastro(new Date());
		evangelizadorRepositorio.save(evangelizador);
	}

	@Transacional
	public void excluir(Evangelizador evangelizador) {
		evangelizadorRepositorio.delete(evangelizador);
	}
	
	public List<Evangelizador> listarTodos(){
		return (List<Evangelizador>) evangelizadorRepositorio.findAll();
	}

}
