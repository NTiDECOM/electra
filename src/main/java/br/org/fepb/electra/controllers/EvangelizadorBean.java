package br.org.fepb.electra.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.DragDropEvent;

import br.org.fepb.electra.daos.EvangelizadorRepositorio;
import br.org.fepb.electra.daos.InstituicaoEspiritaRepositorio;
import br.org.fepb.electra.models.Evangelizador;
import br.org.fepb.electra.models.InstituicaoEspirita;
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
	
	@Inject 
	private InstituicaoEspiritaRepositorio instituicaoEspiritaRepositorio;

	private List<Evangelizador> evangelizadores;
	
	private Evangelizador evangelizador;
	
	private List<InstituicaoEspirita> instituicoes;
	
	private List<InstituicaoEspirita> droppedInstituicoes;
	
	private InstituicaoEspirita selectedInstituicao;
	

	/** Método para iniciar a tela de cadastro de evangelizadores */
	public String iniciar() {
		this.limparVariaveis();
		this.instituicoes = instituicaoEspiritaRepositorio.listarTodos();
		this.droppedInstituicoes = new ArrayList<>();
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
		this.instituicoes = null;
		this.droppedInstituicoes = null;
		this.selectedInstituicao = null;
		this.evangelizadores = evangelizadorRepositorio.listarTodos();
	}
	
	public void prepararNovoCadastro() {
		evangelizador = new Evangelizador();
		setState(ESTADO_DE_NOVO);
	}
	
	public void salvar() {
		if(!droppedInstituicoes.isEmpty()){
			evangelizador.setInstituicoesEspiritas(droppedInstituicoes);
		}
		evangelizadorService.salvar(evangelizador);
		messages.info("Evangelizador salvo com sucesso!");
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:evangelizadores-table"));
	}
	
	public void prepararEdicao() {
		droppedInstituicoes = evangelizador.getInstituicoesEspiritas();
		instituicoes = instituicaoEspiritaRepositorio.listarTodos();
		if(droppedInstituicoes!=null && instituicoes !=null){
			instituicoes.removeAll(droppedInstituicoes);
		}
		setState(ESTADO_DE_EDICAO);
	}
	
	public void excluir() {
		evangelizadorService.excluir(evangelizador);
		evangelizador = null;
		messages.info("Evangelizador(a) excluído(a) com sucesso!");
		listar();
	}

	public List<InstituicaoEspirita> getInstituicoes() {
		if(instituicoes == null){
			instituicoes = instituicaoEspiritaRepositorio.listarTodos();
		}
		return instituicoes;
	}
	
    public void onInstituicaoDrop(DragDropEvent ddEvent) {
        InstituicaoEspirita instituicaoEspirita = ((InstituicaoEspirita) ddEvent.getData());
        if(droppedInstituicoes == null){
        	droppedInstituicoes = new ArrayList<>();
        }
        droppedInstituicoes.add(instituicaoEspirita);
        selectedInstituicao = instituicaoEspirita;
        instituicoes.remove(instituicaoEspirita);
    }
    
    public void cancelInstituicaoDrop() {
    	droppedInstituicoes.clear();
    	selectedInstituicao = null;
    	instituicoes = instituicaoEspiritaRepositorio.listarTodos();
      
    }
	
	public List<Evangelizador> getEvangelizadores() {
		if(evangelizadores == null){
			return evangelizadorRepositorio.listarTodos();
		}
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

	public List<InstituicaoEspirita> getDroppedInstituicoes() {
		return droppedInstituicoes;	
	}

	public void setDroppedInstituicoes(List<InstituicaoEspirita> droppedInstituicoes) {
		this.droppedInstituicoes = droppedInstituicoes;
	}

	public InstituicaoEspirita getSelectedInstituicao() {
		return selectedInstituicao;
	}

	public void setSelectedInstituicao(InstituicaoEspirita selectedInstituicao) {
		this.selectedInstituicao = selectedInstituicao;
	}
	
}
