package br.org.fepb.electra.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Matricula;

@Repository
public interface MatriculaRepositorio extends CrudRepository<Matricula, Long> {

	
}
