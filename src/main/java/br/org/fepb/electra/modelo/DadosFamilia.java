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
@Table(name = "tb_dados_familia")
@Component
public class DadosFamilia implements Serializable {
    
	private static final long serialVersionUID = -4128383655069957459L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name="nome_mae")
    private String nomeMae;
    
	@Column(name="nome_pai")
    private String nomePai;
    
	@Column(name="expectativa_aulas")
    private String expectativaAulas;
    
	@Column(name="parentes_com_quem_reside")
    private String parentesComQuemReside;
    
	@Column(name="telefone1")
    private String telefone1;
    
	@Column(name="telefone2")
    private String telefone2;
    
	@Column(name="observacoes")
    private String observacoes;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
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

	public String getParentesComQuemReside() {
		return parentesComQuemReside;
	}

	public void setParentesComQuemReside(String parentesComQuemReside) {
		this.parentesComQuemReside = parentesComQuemReside;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
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