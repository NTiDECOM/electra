package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.org.fepb.electra.modelo.Evangelizando;
import br.org.fepb.electra.repositorios.EvangelizandoRepositorio;
import br.org.fepb.electra.util.Transacional;

public class EvangelizandoService implements Serializable {

	private static final long serialVersionUID = 5712580837918380230L;
	
	@Inject
	private EvangelizandoRepositorio evangelizandoRepositorio;

	@Transacional
	public Evangelizando salvar(Evangelizando evangelizando) {
		evangelizando.setDataCadastro(new Date());
		return evangelizandoRepositorio.salvar(evangelizando);
	}

	@Transacional
	public void excluir(Evangelizando evangelizando) {
		evangelizandoRepositorio.remover(evangelizando);
	}
	
}
