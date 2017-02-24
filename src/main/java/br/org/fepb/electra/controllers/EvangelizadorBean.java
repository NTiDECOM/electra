package br.org.fepb.electra.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.org.fepb.electra.daos.EvangelizadorRepositorio;
import br.org.fepb.electra.models.Evangelizador;
import br.org.fepb.electra.services.EvangelizadorService;
import br.org.fepb.electra.util.FacesMessages;

@Named
@ViewScoped
public class EvangelizadorBean extends GenericBean {

	private static final long serialVersionUID = -1745521686277227026L;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private EvangelizadorService evangelizadorService;
	
	@Inject
	private EvangelizadorRepositorio evangelizadorRepositorio;

	private List<Evangelizador> evangelizadores;
	
	private Evangelizador evangelizador;
	

	/** Método para iniciar a tela de cadastro de evangelizadores */
	public String iniciar() {
		this.limparVariaveis();
		return "/pages/Evangelizador";
	}
	
	public void listar() {
		limparVariaveis();
		evangelizadores = evangelizadorRepositorio.listarTodos();
	}
	
	public void cancelar() {
		limparVariaveis();
	}
	
	private void limparVariaveis() {
		setState(ESTADO_DE_LISTAGEM);
		this.evangelizador = null;
		if ( evangelizadores == null)
			evangelizadores = new ArrayList<Evangelizador>();
		else
			evangelizadores.clear();
	}
	
	public void prepararNovoCadastro() {
		evangelizador = new Evangelizador();
		setState(ESTADO_DE_NOVO);
	}
	
	public void salvar() {
		evangelizadorService.salvar(evangelizador);
		messages.info("Evangelizador salvo com sucesso!");
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:evangelizadores-table"));
	}
	
	public void prepararEdicao() {
		setState(ESTADO_DE_EDICAO);
	}
	
	public void excluir() {
		evangelizadorService.excluir(evangelizador);
		evangelizador = null;
		messages.info("Evangelizador(a) excluído(a) com sucesso!");
		listar();
	}

	public List<Evangelizador> getEvangelizadores() {
		return evangelizadores;
	}

	public void setEvangelizadores(List<Evangelizador> evangelizadores) {
		this.evangelizadores = evangelizadores;
	}

	public Evangelizador getEvangelizador() {
		return evangelizador;
	}

	public void setEvangelizador(Evangelizador evangelizador) {
		this.evangelizador = evangelizador;
	}
	
}
