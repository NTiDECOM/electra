package br.org.fepb.electra.repositorios;

import br.org.fepb.electra.modelo.UnidadeFederativa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeFederativaRepositorio extends CrudRepository<UnidadeFederativa, Long>{

}
