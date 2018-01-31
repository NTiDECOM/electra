package br.org.fepb.electra.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Evangelizador;


@Repository
public interface EvangelizadorRepositorio extends CrudRepository<Evangelizador, Long> {

	
}
