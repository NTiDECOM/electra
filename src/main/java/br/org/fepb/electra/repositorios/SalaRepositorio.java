package br.org.fepb.electra.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Sala;

@Repository
public interface SalaRepositorio extends CrudRepository<Sala, Long> {

	public List<Sala> findAllByInstituicao(Long idInstituicao);
	
}
