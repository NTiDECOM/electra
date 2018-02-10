package br.org.fepb.electra.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Sala;

@Repository
public interface SalaRepositorio extends CrudRepository<Sala, Long> {

	@Query(value = "select * from tb_sala where fk_instituicao = :idInstituicao", nativeQuery = true)
	public List<Sala> findAllByInstituicao(@Param("idInstituicao") Long idInstituicao);
	
}
