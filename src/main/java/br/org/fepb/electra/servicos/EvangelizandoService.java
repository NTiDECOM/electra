package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.Evangelizando;
import br.org.fepb.electra.repositorios.EvangelizandoRepositorio;
import br.org.fepb.electra.util.Transacional;

@Service
public class EvangelizandoService implements Serializable {

	private static final long serialVersionUID = 5712580837918380230L;
	
	//@Inject
	@Autowired
	private EvangelizandoRepositorio evangelizandoRepositorio;

	@Transacional
	public Evangelizando salvar(Evangelizando evangelizando) {
		evangelizando.setDataCadastro(new Date());
		return evangelizandoRepositorio.save(evangelizando);
	}

	@Transacional
	public void excluir(Evangelizando evangelizando) {
		evangelizandoRepositorio.delete(evangelizando);
	}
	
}
