package br.org.fepb.electra.controladores;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.modelo.Sala;
import br.org.fepb.electra.servicos.InstituicaoEspiritaService;
import br.org.fepb.electra.servicos.SalaService;
import br.org.fepb.electra.util.FacesMessages;


@Controller("salaBean")
@ViewScoped
public class SalaBean extends GenericBean {

	private static final long serialVersionUID = -35739181856698227L;

	@Autowired
	private FacesMessages messages;
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private InstituicaoEspiritaService instituicaoService;
	
	@NotNull
	private InstituicaoEspirita instituicaoSelecionada;

	private List<InstituicaoEspirita> instituicoesEspiritas;
	
	private Sala sala;
	
	private List<Sala> salas;
	
	/** Método para iniciar a tela de cadastro de instituição */
	@PostConstruct
	public String iniciar() {
		limparVariaveis();
		this.instituicoesEspiritas = instituicaoService.listarTodos();
		this.salas = salaService.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Sala";
	}
	
	public void listar() {
		limparVariaveis();
		salas = salaService.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		salas = salaService.listarTodos();
		instituicaoSelecionada = new InstituicaoEspirita();
		sala = null;
	}
	
	public void prepararNovoCadastro() {
		sala = new Sala();
		instituicaoSelecionada = null;
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
		instituicaoSelecionada = sala.getInstituicao();
		setState(ESTADO_DE_EDICAO);
	}
	
	public void salvar() {
		try {
		sala.setInstituicao(instituicaoSelecionada);
		salaService.salvar(sala);
		messages.info("Registro gravado com sucesso!");
		} catch (Exception e) {
			messages.error("Ocorreu uma falha no processamento");
		}
		//limpar dados
		limparVariaveis();
		//listar
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:salas-table"));
	}
	
	public void excluir() {
		salaService.excluir(sala);
		messages.info("Registro excluído com sucesso!");
		listar();
	}

	public void cancelar() {
		listar();
	}

	
	// **** GETs e SETs ****//

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Sala> getSalas() {
		if(salas == null || salas.size() == 0){
			return salaService.listarTodos();
		}
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public InstituicaoEspirita getInstituicaoSelecionada() {
		return instituicaoSelecionada;
	}

	public void setInstituicaoSelecionada(InstituicaoEspirita instituicaoSelecionada) {
		this.instituicaoSelecionada = instituicaoSelecionada;
	}

	public List<InstituicaoEspirita> getInstituicoesEspiritas() {
		return instituicoesEspiritas;
	}

	public void setInstituicoesEspiritas(List<InstituicaoEspirita> instituicoesEspiritas) {
		this.instituicoesEspiritas = instituicoesEspiritas;
	}
	
	
}
