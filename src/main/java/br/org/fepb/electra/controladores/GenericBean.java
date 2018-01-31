package br.org.fepb.electra.controladores;

import java.io.Serializable;
import java.util.List;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.org.fepb.electra.repositorios.BairroRepositorio;

/**
 * Classe responsável por representar o estado da página.
 * 
 * @author Sávio Canuto.
 */
public class GenericBean implements Serializable {

	private static final long serialVersionUID = 1L;
	//
	static final String ESTADO_DE_LISTAGEM = "_listagem";
	static final String ESTADO_DE_NOVO = "_novo";
	static final String ESTADO_DE_EDICAO = "_edicao";
	static final String ESTADO_DE_VISUALIZACAO = "_visualizar";

	private String state = ESTADO_DE_LISTAGEM;

	@Autowired
	private BairroRepositorio bairroRepositorio;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isAdicionando() {
		return ESTADO_DE_NOVO.equals(state);
	}

	public boolean isEditando() {
		return ESTADO_DE_EDICAO.equals(state);
	}

	/** Estado para tela de listagem */
	public boolean isListando() {
		return ESTADO_DE_LISTAGEM.equals(state);
	}

	/**
	 * Estado para tela de visualizar. Quando uma tela possui muitos campos e
	 * não cabe na listagem principal, faz a visualização numa tela separada, e
	 * usa essa propriedade para renderizar.
	 */
	public boolean isVisualizando() {
		return ESTADO_DE_VISUALIZACAO.equals(state);
	}

	public void atualizarCamposDaTela(List<String> campos) {
		RequestContext.getCurrentInstance().update(campos);
	}

}
