package br.org.fepb.electra.controllers;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotEmpty;

import br.org.fepb.electra.models.InstituicaoEspirita;
import br.org.fepb.electra.services.InstituicaoEspiritaService;
import br.org.fepb.electra.util.FacesMessages;

@Named("instituicaoEspiritaBean")
@ViewScoped
public class InstituicaoEspiritaBean extends GenericBean {

	private static final long serialVersionUID = -8329219684847899990L;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private InstituicaoEspiritaService instituicaoService;
	
	private List<InstituicaoEspirita> instituicoes;
	
	private InstituicaoEspirita instituicao;
	
	@NotEmpty
	private String campoTipo;
	

	/** Método para iniciar a tela de cadastro de instituição */
	public String iniciar() {
		listar();
		return "/pages/InstituicaoEspirita";
	}
	
	public void listar() {
		limparVariaveis();
		instituicoes = instituicaoService.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		instituicoes = instituicaoService.listarTodos();
		instituicao = null;
		campoTipo = null;
	}
	
	public void prepararNovoCadastro() {
		instituicao = new InstituicaoEspirita();
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
		campoTipo = instituicao.getTipo();
		setState(ESTADO_DE_EDICAO);
	}
	
	public void salvar() {
		instituicao.setTipo(campoTipo);
		instituicaoService.salvar(instituicao);
		messages.info("Instituição salva com sucesso!");
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:instituicoes-table"));
	}
	
	public void excluir() {
		try {
		instituicaoService.excluir(instituicao);
		messages.info("Instituição excluída com sucesso!");
		listar();
		} catch (Exception e) {
			e.printStackTrace();
			messages.error("Existe uma sala vinculada. Para remoção completa, primeiramente precisa remover a sala dependente");
			
		}
	}

	public void cancelar() {
		listar();
	}
	
	
	// **** GETs e SETs ****//
	public List<InstituicaoEspirita> getInstituicoes() {
		if(instituicoes == null){
			return instituicaoService.listarTodos();
		}
		return instituicoes;
	}
	
	public void setInstituicoes(List<InstituicaoEspirita> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
	public InstituicaoEspirita getInstituicao() {
		return instituicao;
	}
	
	public void setInstituicao(InstituicaoEspirita instituicao) {
		this.instituicao = instituicao;
	}

	public String getCampoTipo() {
		return campoTipo;
	}

	public void setCampoTipo(String campoTipo) {
		this.campoTipo = campoTipo;
	}

}
