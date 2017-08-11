package br.org.fepb.electra.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Evangelizador extends Pessoa {

	private static final long serialVersionUID = -2485532690960892476L;

	@NotEmpty
	@Column(name = "escolaridade", length = 60)
	private String escolaridade;

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	
}
