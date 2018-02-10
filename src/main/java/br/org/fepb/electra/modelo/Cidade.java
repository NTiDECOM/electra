package br.org.fepb.electra.modelo;

import javax.persistence.*;

@Entity
@Table(name = "tb_cidade")
public class Cidade extends GenericModel {
    
	private static final long serialVersionUID = -8065445952534438155L;

    @Column(name="descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="fk_uf")
    private UnidadeFederativa uf;
	
	public Cidade(){
		//vazio
	}
	

	public Cidade(String descricao, UnidadeFederativa uf) {
		super();
		this.descricao = descricao;
		this.uf = uf;
	}


	public Cidade(Long id) {
		setId(id);
	}

	@Override
	public Long getId() {
		return super.getId();
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public UnidadeFederativa getUf() {
		return uf;
	}

	public void setUf(UnidadeFederativa uf) {
		this.uf = uf;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return descricao;
	}
}