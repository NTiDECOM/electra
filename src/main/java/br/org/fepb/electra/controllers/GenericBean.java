package br.org.fepb.electra.controllers;


public class GenericBean {
	
	static final String ESTADO_DE_LISTAGEM 		= "_listagem";
	static final String ESTADO_DE_NOVO 			= "_novo";
	static final String ESTADO_DE_EDICAO 		= "_edicao";
	static final String ESTADO_DE_VISUALIZACAO 	= "_visualizar";
	
	private String state = ESTADO_DE_LISTAGEM;

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

}
