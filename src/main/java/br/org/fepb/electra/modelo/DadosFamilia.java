package br.org.fepb.electra.modelo;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_dados_familia")
@Component
public class DadosFamilia implements Serializable {
    
	private static final long serialVersionUID = -4128383655069957459L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotNull
	@Column(name="evangelho_lar")
	private Boolean evangelhoLar;
	
	@Column(name="expectativa_aulas")
    private String expectativaAulas;
    
	@Column(name="observacoes")
    private String observacoes;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Parente> parentes = new ArrayList<>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpectativaAulas() {
		return expectativaAulas;
	}

	public void setExpectativaAulas(String expectativaAulas) {
		this.expectativaAulas = expectativaAulas;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Boolean getEvangelhoLar() {
		return evangelhoLar;
	}

	public void setEvangelhoLar(Boolean evangelhoLar) {
		this.evangelhoLar = evangelhoLar;
	}

	public List<Parente> getParentes() {
		return parentes;
	}

	public void setParentes(List<Parente> parentes) {
		this.parentes = parentes;
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
		DadosFamilia other = (DadosFamilia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}