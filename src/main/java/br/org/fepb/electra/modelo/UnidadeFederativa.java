package br.org.fepb.electra.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_unidade_federativa")
public class UnidadeFederativa extends GenericModel implements Serializable{
    
	private static final long serialVersionUID = -8591357257537938081L;

    private String descricao;

	@Column(name = "sigla", nullable = false)
    private String sigla;

	@ManyToOne
	@JoinColumn(name="fk_regiao")
	private Regiao regiao;

    public UnidadeFederativa(){
    	//vazio
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		UnidadeFederativa other = (UnidadeFederativa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}