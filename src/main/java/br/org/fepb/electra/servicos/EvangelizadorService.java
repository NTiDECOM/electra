package br.org.fepb.electra.servicos;

import br.org.fepb.electra.modelo.Evangelizador;
import br.org.fepb.electra.repositorios.EvangelizadorRepositorio;
import br.org.fepb.electra.util.Transacional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class EvangelizadorService implements Serializable, ServiceInterface<Evangelizador> {
	
	private static final long serialVersionUID = -4802660230220768541L;
	
	@Autowired
	private EvangelizadorRepositorio evangelizadorRepositorio;

	@Transacional
	public Evangelizador salvar(Evangelizador evangelizador) {
		evangelizador.setDataCadastro(new Date());
		return evangelizadorRepositorio.save(evangelizador);
	}

	@Transacional
	public void excluir(Evangelizador evangelizador) {
		evangelizadorRepositorio.delete(evangelizador);
	}
	
	public List<Evangelizador> listarTodos(){
		return (List<Evangelizador>) evangelizadorRepositorio.findAll();
	}

}
