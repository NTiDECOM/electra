package br.org.fepb.electra.services;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.org.fepb.electra.daos.EvangelizandoRepositorio;
import br.org.fepb.electra.models.Evangelizando;
import br.org.fepb.electra.util.Transacional;

public class EvangelizandoService implements Serializable {

	private static final long serialVersionUID = 5712580837918380230L;
	
	@Inject
	private EvangelizandoRepositorio evangelizandoRepositorio;

	@Transacional
	public void salvar(Evangelizando evangelizando) {
		evangelizando.setDataCadastro(new Date());
		evangelizandoRepositorio.salvar(evangelizando);
	}

	@Transacional
	public void excluir(Evangelizando evangelizando) {
		evangelizandoRepositorio.remover(evangelizando);
	}
	
}
