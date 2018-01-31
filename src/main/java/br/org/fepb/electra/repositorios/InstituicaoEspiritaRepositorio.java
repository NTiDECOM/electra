package br.org.fepb.electra.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.InstituicaoEspirita;

@Repository
public interface InstituicaoEspiritaRepositorio extends CrudRepository<InstituicaoEspirita, Long> {

	
}
