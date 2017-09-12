package br.org.fepb.electra.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import br.org.fepb.electra.daos.EvangelizandoRepositorio;
import br.org.fepb.electra.models.Evangelizando;
import br.org.fepb.electra.services.EvangelizandoService;
import br.org.fepb.electra.services.InstituicaoEspiritaService;
import br.org.fepb.electra.services.SalaService;
import br.org.fepb.electra.util.FacesMessages;

@Named
@ViewScoped
public class EvangelizandoBean extends GenericBean {

	private static final long serialVersionUID = 8390437989517939381L;
	
	@Inject
	private MatriculaBean matriculaBean;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private EvangelizandoService evangelizandoServico;
	
	@Inject
	private InstituicaoEspiritaService instituicaoServico;
	
	@Inject
	private SalaService salaServico;
	
	@Inject
	private EvangelizandoRepositorio evangelizandoRepositorio;

	private List<Evangelizando> evangelizandos;
	
	private Evangelizando evangelizando;
	
	@Inject
	private ServletContext servletContext;
	
	/** Método para iniciar a tela de cadastro de evangelizandos */
	public String iniciar() {
		this.limparVariaveis();
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Evangelizando";
	}
	
	public String cancelar() {
		limparVariaveis();
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
		this.evangelizando = new Evangelizando();
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
	}
	
	public String salvar() {
		evangelizando = evangelizandoServico.salvar(evangelizando);
		messages.info("Evangelizando salvo com sucesso! Realize agora a matrícula...");
		listar();
		servletContext.setAttribute("evangelizando", evangelizando);
 		return "/pages/Matricula";
	}
	
	public void excluir() {
		try {
		evangelizandoServico.excluir(evangelizando);
		evangelizando = null;
		messages.info("Evangelizando(a) excluído(a) com sucesso!");
		listar();
		} catch (Exception e) {
			e.printStackTrace();
			messages.error("Existe uma matrícula vinculada. Para remoção completa, primeiramente precisa remover a matrícula dependente");
			
		}
	}
	
	public List<Evangelizando> getEvangelizandos() {
		if(evangelizandos == null){
			return evangelizandoRepositorio.listarTodos();
		}
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
