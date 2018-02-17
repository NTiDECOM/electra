package br.org.fepb.electra.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.InstituicaoEspirita;

import java.util.List;

@Repository
public interface InstituicaoEspiritaRepositorio extends CrudRepository<InstituicaoEspirita, Long> {

    @Override
    @Query(value = "from InstituicaoEspirita order by id desc")
    List<InstituicaoEspirita> findAll();
}
