package br.org.fepb.electra.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.modelo.Sala;
import br.org.fepb.electra.servicos.InstituicaoEspiritaService;
import br.org.fepb.electra.servicos.SalaService;
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
	
	@NotNull
	private Long idInstituicao;
	
	private Sala sala;
	
	private List<Sala> salas;
	
	/** Método para iniciar a tela de cadastro de instituição */
	public String iniciar() {
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
		idInstituicao = null;
		sala = null;
	}
	
	public void prepararNovoCadastro() {
		sala = new Sala();
		idInstituicao = null;
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
		idInstituicao = sala.getInstituicao().getId();
		setState(ESTADO_DE_EDICAO);
	}
	
	public void salvar() {
		try {
		sala.setInstituicao(new InstituicaoEspirita(idInstituicao));
		salaService.salvar(sala);
		messages.info("Registro gravado com sucesso!");
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:salas-table"));
		} catch (Exception e) {
			messages.error("Ocorreu uma falha no processamento");
		}
	}
	
	public void excluir() {
		salaService.excluir(sala);
		messages.info("Registro excluído com sucesso!");
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
	
	public String recuperarInstituicao(Long idInstituicao) {
		String retorno = "-";
		
		InstituicaoEspirita instituicao = instituicaoService.pesquisarPorId(idInstituicao);
		if ( instituicao != null )
			retorno = instituicao.getNome() + " - " + instituicao.getPresidente();
	
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
		if(salas == null){
			return salaService.listarTodos();
		}
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	
}
