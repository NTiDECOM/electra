package br.org.fepb.electra.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.org.fepb.electra.conversores.BaseEntity;

@Entity
@Table(name = "tb_bairro")
public class Bairro extends GenericModel implements BaseEntity {
    
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
	
	
    
    
}