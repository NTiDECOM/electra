package br.org.fepb.electra.servicos;

import br.org.fepb.electra.modelo.Evangelizando;
import br.org.fepb.electra.repositorios.EvangelizandoRepositorio;
import br.org.fepb.electra.util.DateUtil;
import br.org.fepb.electra.util.Transacional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EvangelizandoService implements Serializable, ServiceInterface<Evangelizando> {

	private static final long serialVersionUID = 5712580837918380230L;
	
	//@Inject
	@Autowired
	private EvangelizandoRepositorio evangelizandoRepositorio;

	@Transacional
	public Evangelizando salvar(Evangelizando evangelizando) {
		evangelizando.setDataCadastro(new Date());
		return evangelizandoRepositorio.save(evangelizando);
	}

	@Transacional
	public void excluir(Evangelizando evangelizando) {
		evangelizandoRepositorio.delete(evangelizando);
	}

	@Override
	public List<Evangelizando> listarTodos() {
		return (List<Evangelizando>) evangelizandoRepositorio.findAll();
	}

	public int contaPorDataNascimento(Date data){
		return evangelizandoRepositorio.contaEvangelizandosPorDataNascimento(DateUtil.formatarData(data, "dd/MM/yyyy"));
	}

	public List<Evangelizando> buscarPorDataNasc(String dataNasc){
		return evangelizandoRepositorio.buscarPorDataNasc(dataNasc);
	}
}
