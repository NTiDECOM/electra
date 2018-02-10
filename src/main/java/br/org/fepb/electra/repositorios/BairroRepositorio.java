package br.org.fepb.electra.repositorios;

import br.org.fepb.electra.modelo.Bairro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BairroRepositorio extends CrudRepository<Bairro, Long>{

    @Query(value = "select b from Bairro b where b.cidade.id = :idCidade")
    //@Query(value = "select * from tb_bairro where fk_cidade = 2507507", nativeQuery = true)
    List<Bairro> findAllByCidade(@Param("idCidade") Long idCidade);

    Bairro findByDescricao(String bairroSelecionado);
}
