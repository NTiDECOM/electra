package br.org.fepb.electra.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import br.org.fepb.electra.conversores.EntidadeBasica;

@Entity
@Table(name = "tb_bairro")
@Component
public class Bairro extends GenericModel implements EntidadeBasica, Serializable {
    
	private static final long serialVersionUID = 8614111716431677593L;

	@Column(name="descricao")
    private String descricao;

    //@JoinColumn(name="fk_cidade")
    @Column(name="fk_cidade")
    private Integer cidade = 1;

	public Bairro(Long idBairro) {
		setId(idBairro);
	}
	
	public Bairro(Long id, String descricao) {
		super();
		this.setId(id);
		this.descricao = descricao;
		//this.cidade = new Cidade(idCidade);
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

	@Override
	public String toString() {
		return descricao;
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
		Bairro other = (Bairro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
    
    
}