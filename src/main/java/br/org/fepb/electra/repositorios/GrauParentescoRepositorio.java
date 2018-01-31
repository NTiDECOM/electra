package br.org.fepb.electra.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.GrauParentesco;

@Repository
public interface GrauParentescoRepositorio extends CrudRepository<GrauParentesco, Long>{

}
