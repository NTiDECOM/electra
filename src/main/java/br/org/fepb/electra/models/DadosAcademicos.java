package br.org.fepb.electra.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dados_academicos")
public class DadosAcademicos implements Serializable {
    
	private static final long serialVersionUID = -7137504587799282677L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="alfabetizado")
	private Boolean alfabetizado;
	
    @Column(name="dificuldades_aprendizado")
	private String dificuldadesAprendizado;
	
    @Column(name="nivel")
    private String nivel;
    
    @Column(name="observacoes")
	private String observacoes;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean isAlfabetizado() {
		return alfabetizado;
	}

	public void setAlfabetizado(Boolean alfabetizado) {
		this.alfabetizado = alfabetizado;
	}

	public String getDificuldadesAprendizado() {
		return dificuldadesAprendizado;
	}

	public void setDificuldadesAprendizado(String dificuldadesAprendizado) {
		this.dificuldadesAprendizado = dificuldadesAprendizado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Boolean getAlfabetizado() {
		return alfabetizado;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
}
