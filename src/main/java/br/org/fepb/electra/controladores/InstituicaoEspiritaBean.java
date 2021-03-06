package br.org.fepb.electra.controladores;

import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.servicos.InstituicaoEspiritaService;
import br.org.fepb.electra.util.FacesMessages;

@Controller("instituicaoEspiritaBean")
@ViewScoped
public class InstituicaoEspiritaBean extends GenericBean {

	private static final long serialVersionUID = -8329219684847899990L;

	//@Inject
	@Autowired
	private FacesMessages messages;
	
	//@Inject
		@Autowired
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
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:instituicoes-table"));
		//limpar dados
		limparVariaveis();
		//listar
		listar();
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

	public String getMaskTelefone() {
		if(this.instituicao.getTipoTelefone()!=null &&
				this.instituicao.getTipoTelefone().equalsIgnoreCase("RESIDENCIAL")){
			return "(99)9999-9999";
		} else {
			return "(99)99999-9999";
		}
	}

	// **** GETs e SETs ****//
	public List<InstituicaoEspirita> getInstituicoes() {
		if(instituicoes == null || instituicoes.size() == 0){
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
