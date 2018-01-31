package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.repositorios.InstituicaoEspiritaRepositorio;
import br.org.fepb.electra.util.Transacional;

@Service
public class InstituicaoEspiritaService implements Serializable {

	private static final long serialVersionUID = 8460255497365537489L;

	//@Inject
	@Autowired
	private InstituicaoEspiritaRepositorio instituicaoRepositorio;
	
	public InstituicaoEspirita pesquisarPorId(Long id) {
		return instituicaoRepositorio.findOne(id);
	}
	
	public List<InstituicaoEspirita> listarTodos() {
		return (List<InstituicaoEspirita>) instituicaoRepositorio.findAll();
	}

	@Transacional
	public void salvar(InstituicaoEspirita evangelizador) {
		instituicaoRepositorio.save(evangelizador);
	}

	@Transacional
	public void excluir(InstituicaoEspirita evangelizador) {
		instituicaoRepositorio.delete(evangelizador);
	}

}
