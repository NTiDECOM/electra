package br.org.fepb.electra.servicos;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.repositorios.InstituicaoEspiritaRepositorio;
import br.org.fepb.electra.util.Transacional;

@Service
public class InstituicaoEspiritaService implements Serializable, ServiceInterface<InstituicaoEspirita> {

	private static final long serialVersionUID = 8460255497365537489L;

	@Autowired
	private InstituicaoEspiritaRepositorio instituicaoRepositorio;
	
	/*public Optional<InstituicaoEspirita> pesquisarPorId(Long id) {
		return instituicaoRepositorio.findById(id);
	}*/
	
	public List<InstituicaoEspirita> listarTodos() {
		return (List<InstituicaoEspirita>) instituicaoRepositorio.findAll();
	}

	@Transacional
	public InstituicaoEspirita salvar(InstituicaoEspirita evangelizador) {
		return instituicaoRepositorio.save(evangelizador);
	}

	@Transacional
	public void excluir(InstituicaoEspirita evangelizador) {
		instituicaoRepositorio.delete(evangelizador);
	}

}
