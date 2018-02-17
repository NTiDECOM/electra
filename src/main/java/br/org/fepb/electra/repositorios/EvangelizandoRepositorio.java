package br.org.fepb.electra.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.org.fepb.electra.modelo.Evangelizando;

import java.util.List;

@Repository
public interface EvangelizandoRepositorio extends CrudRepository<Evangelizando, Long> {

    @Query(value = "select count(*) from electra.tb_evangelizando " +
            "where data_nascimento = STR_TO_DATE(:dataFormatada, '%d/%m/%Y')",
            nativeQuery = true)
	public int contaEvangelizandosPorDataNascimento(@Param("dataFormatada") String dataFormatada);

    @Query(value = "select * from electra.tb_evangelizando " +
            "where data_nascimento = STR_TO_DATE(:dataNasc, '%d/%m/%Y')",
            nativeQuery = true)
    List<Evangelizando> buscarPorDataNasc(@Param("dataNasc") String dataNasc);

    @Query(value = "select * from electra.tb_evangelizando where id not in (select fk_evangelizando from tb_matricula)" +
            " union select * from electra.tb_evangelizando where id in (select fk_evangelizando from tb_matricula where situacao = 'CANCELADA' or situacao = 'EVADIDO')",
            nativeQuery = true)
    List<Evangelizando> listarEvangelizandosSemMatricula();

    @Override
    @Query("from Evangelizando order by id desc")
    List<Evangelizando> findAll();
}
