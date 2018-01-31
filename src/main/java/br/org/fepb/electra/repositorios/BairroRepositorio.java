package br.org.fepb.electra.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Bairro;

@Repository
public interface BairroRepositorio extends CrudRepository<Bairro, Long>{

	
}
