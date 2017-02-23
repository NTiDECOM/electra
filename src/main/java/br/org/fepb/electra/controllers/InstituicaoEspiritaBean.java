package br.org.fepb.electra.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.org.fepb.electra.models.InstituicaoEspirita;
import br.org.fepb.electra.services.InstituicaoEspiritaService;
import br.org.fepb.electra.util.FacesMessages;

@Named
@ViewScoped
public class InstituicaoEspiritaBean extends GenericBean {

	private static final long serialVersionUID = -8329219684847899990L;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private InstituicaoEspiritaService instituicaoService;
	
	private List<InstituicaoEspirita> instituicoes;
	
	private InstituicaoEspirita instituicao;
	

	/** Método para iniciar a tela de cadastro de instituição */
	public String iniciar() {
		this.limparVariaveis();
		return "/pages/InstituicaoEspirita";
	}
	
	public void listar() {
		limparVariaveis();
		instituicoes = instituicaoService.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		if ( instituicoes == null)
			instituicoes = new ArrayList<InstituicaoEspirita>();
		else
			instituicoes.clear();
		instituicao = new InstituicaoEspirita();
	}
	
	public void prepararNovoCadastro() {
		instituicao = new InstituicaoEspirita();
		setState(ESTADO_DE_NOVO);
	}
	
	public void salvar() {
		instituicaoService.salvar(instituicao);
		messages.info("Instituição salva com sucesso!");
		listar();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		instituicaoService.excluir(instituicao);
		instituicao = null;
		messages.info("Instituição excluída com sucesso!");
		listar();
	}
}
