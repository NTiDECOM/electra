package br.org.fepb.electra.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Evangelizando;

@Repository
public interface EvangelizandoRepositorio extends CrudRepository<Evangelizando, Long> {

	
	
}
