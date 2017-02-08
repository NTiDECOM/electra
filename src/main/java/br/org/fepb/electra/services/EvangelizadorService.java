package br.org.fepb.electra.services;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.org.fepb.electra.daos.EvangelizadorRepositorio;
import br.org.fepb.electra.models.Evangelizador;
import br.org.fepb.electra.util.Transacional;

public class EvangelizadorService implements Serializable {
	
	private static final long serialVersionUID = -4802660230220768541L;
	
	@Inject
	private EvangelizadorRepositorio evangelizadorRepositorio;

	@Transacional
	public void salvar(Evangelizador evangelizador) {
		evangelizador.setDataCadastro(new Date());
		evangelizadorRepositorio.salvar(evangelizador);
	}

	@Transacional
	public void excluir(Evangelizador evangelizador) {
		evangelizadorRepositorio.remover(evangelizador);
	}

}
