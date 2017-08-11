package br.org.fepb.electra.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Evangelizando extends Pessoa {

	private static final long serialVersionUID = 7927686865996077792L;
	
	@Column(name = "idSala")
	private Long idSala;

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}
	
}
