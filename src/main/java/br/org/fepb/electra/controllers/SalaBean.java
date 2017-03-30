package br.org.fepb.electra.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.org.fepb.electra.models.InstituicaoEspirita;
import br.org.fepb.electra.models.Sala;
import br.org.fepb.electra.services.SalaService;
import br.org.fepb.electra.util.FacesMessages;


@Named("salaBean")
@ViewScoped
public class SalaBean extends GenericBean {

	private static final long serialVersionUID = -35739181856698227L;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private SalaService salaService;
	
	private List<SelectItem> instituicoes;
	
	private InstituicaoEspirita instituicao;
	
	private Sala sala;
	
	private List<Sala> salas;
	
	/** Método para iniciar a tela de cadastro de instituição */
	public String iniciar() {
		this.listar();
		return "/pages/Sala";
	}
	
	public void listar() {
		limparVariaveis();
		salas = salaService.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		if ( salas == null)
			salas = new ArrayList<Sala>();
		else
			salas.clear();
		
		if ( instituicoes == null )
			instituicoes = new ArrayList<SelectItem>();
		else
			instituicoes.clear();
		
		instituicao = null;
		sala = null;
	}
	
	public void prepararNovoCadastro() {
		sala = new Sala();
		instituicao = new InstituicaoEspirita();
		//TODO realizar consulta de instituicoes para preencher combo
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
		//TODO formatar exibição da selecao da instituicao no combo 
		setState(ESTADO_DE_EDICAO);
	}
	
	public void salvar() {
		sala.setInstituicao(instituicao);
		salaService.salvar(sala);
		messages.info("Sala salva com sucesso!");
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:salas-table"));
	}
	
	public void excluir() {
		salaService.excluir(sala);
		messages.info("Sala excluída com sucesso!");
		listar();
	}

	public void cancelar() {
		listar();
	}
	
	public String formatarFaixaEtaria(Sala sala) {
		return sala.getFaixaEtariaInicial() +" a "+ sala.getFaixaEtariaFinal() + " anos";
	}
	
	public String formatarHorario(Sala sala) {
		return sala.getHoraInicio() + " a " + sala.getHoraTermino();
	}

	
	// **** GETs e SETs ****//
	public List<SelectItem> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<SelectItem> instituicoes) {
		this.instituicoes = instituicoes;
	}

	public InstituicaoEspirita getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoEspirita instituicao) {
		this.instituicao = instituicao;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	
	
}
