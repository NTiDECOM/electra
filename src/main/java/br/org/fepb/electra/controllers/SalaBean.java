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
import br.org.fepb.electra.services.InstituicaoEspiritaService;
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
	
	@Inject
	private InstituicaoEspiritaService instituicaoService;
	
	private Long idInstituicao;
	
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
		
		idInstituicao = null;
		sala = null;
	}
	
	public void prepararNovoCadastro() {
		sala = new Sala();
		idInstituicao = null;
		//TODO realizar consulta de instituicoes para preencher combo
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
		//TODO formatar exibição da selecao da instituicao no combo 
		setState(ESTADO_DE_EDICAO);
	}
	
	public void salvar() {
		sala.setIdInstituicao(idInstituicao);
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

	public List<SelectItem> getInstituicoes() {
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		
		for (InstituicaoEspirita in : instituicaoService.listarTodos()) {
			retorno.add(new SelectItem(in.getId(), in.getNome()));
		}
		return retorno;
	}

	
	// **** GETs e SETs ****//

	public Sala getSala() {
		return sala;
	}

	public Long getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
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
