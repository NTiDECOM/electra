package br.org.fepb.electra.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Matricula;

import java.util.List;

@Repository
public interface MatriculaRepositorio extends CrudRepository<Matricula, Long> {

    @Query(value = "select m from Matricula m where m.evangelizando.dataNascimento = STR_TO_DATE(:dataNasc, '%d/%m/%Y')")
    List<Matricula> buscarPorDataNasc(@Param("dataNasc") String dataNasc);

    @Override
    @Query(value="from Matricula order by id desc")
    List<Matricula> findAll();
}
