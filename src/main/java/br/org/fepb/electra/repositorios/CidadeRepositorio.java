package br.org.fepb.electra.repositorios;

import br.org.fepb.electra.modelo.Cidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepositorio extends CrudRepository<Cidade, Long>{

    @Query(value = "select c from Cidade c where c.uf.sigla = :siglaUF")
    public List<Cidade> findAllBySiglaUF(@Param("siglaUF") String siglaUF);

    Cidade findByDescricao(String naturalidadeSelecionada);
}
