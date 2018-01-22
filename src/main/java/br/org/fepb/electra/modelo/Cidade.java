package br.org.fepb.electra.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
public class Cidade extends GenericModel {
    
	private static final long serialVersionUID = -8065445952534438155L;

    @Column(name="descricao")
    private String descricao;

    @JoinColumn(name="fk_uf")
    @Column(name="fk_uf")
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
    
}