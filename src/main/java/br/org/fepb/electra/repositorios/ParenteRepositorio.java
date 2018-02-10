package br.org.fepb.electra.repositorios;

import br.org.fepb.electra.modelo.DadosFamilia;
import br.org.fepb.electra.modelo.Parente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParenteRepositorio extends CrudRepository<Parente, Long>{

    @Query(value = "select p from Parente p where p.evangelizando.id = :idEvangelizando")
    List<Parente> findAllByEvangelizando(@Param("idEvangelizando") Long idEvangelizando);

}
