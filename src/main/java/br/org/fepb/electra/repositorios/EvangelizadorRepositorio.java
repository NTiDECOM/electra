package br.org.fepb.electra.repositorios;

import br.org.fepb.electra.modelo.Evangelizador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EvangelizadorRepositorio extends CrudRepository<Evangelizador, Long> {

	@Override
    @Query(value = "from Evangelizador order by id desc")
    List<Evangelizador> findAll();
}
