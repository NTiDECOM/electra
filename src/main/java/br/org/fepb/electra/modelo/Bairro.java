package br.org.fepb.electra.modelo;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import br.org.fepb.electra.conversores.EntidadeBasica;

@Entity
@Table(name = "tb_bairro")
public class Bairro extends GenericModel implements Serializable {
    
	private static final long serialVersionUID = 8614111716431677593L;

	@Column(name="descricao")
    private String descricao;

	@Column(name="sigla_uf")
	private String siglaUF;

	@ManyToOne
	@JoinColumn(name="fk_cidade")
    private Cidade cidade;


	public Bairro(Long idBairro) {
		setId(idBairro);
	}
	
	public Bairro(Long id, String descricao, String siglaUF, Cidade cidade) {
		super();
		this.setId(id);
		this.descricao = descricao;
		this.siglaUF = siglaUF;
		this.cidade = cidade;
	}

	public Bairro(){
		//vazio
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Bairro other = (Bairro) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	
    
    
}