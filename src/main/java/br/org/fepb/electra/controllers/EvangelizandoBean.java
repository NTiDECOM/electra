package br.org.fepb.electra.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.org.fepb.electra.daos.EvangelizandoRepositorio;
import br.org.fepb.electra.models.Evangelizando;
import br.org.fepb.electra.services.EvangelizandoService;
import br.org.fepb.electra.util.FacesMessages;

@Named
@ViewScoped
public class EvangelizandoBean extends GenericBean {

	private static final long serialVersionUID = 8390437989517939381L;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private EvangelizandoService evangelizandoService;
	
	@Inject
	private EvangelizandoRepositorio evangelizandoRepositorio;

	private List<Evangelizando> evangelizandos;
	
	private Evangelizando evangelizando;
	

	/** Método para iniciar a tela de cadastro de evangelizandos */
	public String iniciar() {
		this.limparVariaveis();
		return "/pages/Evangelizando";
	}
	
	public void listar() {
		if ( evangelizandos == null)
			evangelizandos = new ArrayList<Evangelizando>();
		else
			evangelizandos.clear();
		
		evangelizandos = evangelizandoRepositorio.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		this.evangelizando = new Evangelizando();
		this.evangelizandos = new ArrayList<Evangelizando>();
	}
	
	public void prepararNovoCadastro() {
		evangelizando = new Evangelizando();
		setState(ESTADO_DE_NOVO);
	}
	
	public void salvar() {
		evangelizandoService.salvar(evangelizando);
		messages.info("Evangelizando salvo com sucesso!");
		listar();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		evangelizandoService.excluir(evangelizando);
		evangelizando = null;
		messages.info("Evangelizando(a) excluído(a) com sucesso!");
		listar();
	}

	public List<Evangelizando> getEvangelizandos() {
		return evangelizandos;
	}

	public void setEvangelizandos(List<Evangelizando> evangelizandos) {
		this.evangelizandos = evangelizandos;
	}

	public Evangelizando getEvangelizando() {
		return evangelizando;
	}

	public void setEvangelizando(Evangelizando evangelizando) {
		this.evangelizando = evangelizando;
	}
	
	
}
