package br.org.fepb.electra.models;

import javax.persistence.Entity;

@Entity
public class InstituicaoEspirita extends GenericModel {

	private static final long serialVersionUID = 8405387162636809655L;
	
	private String nome;
	
	private String evangeliza;

	private String presidente;
	
	private String tipo;
	
	private String telefone;

	// ****** GETs e SETs ********//
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEvangeliza() {
		return evangeliza;
	}

	public void setEvangeliza(String evangeliza) {
		this.evangeliza = evangeliza;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
