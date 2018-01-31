package br.org.fepb.electra.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tb_dados_academicos")
@Component
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosAcademicos other = (DadosAcademicos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
