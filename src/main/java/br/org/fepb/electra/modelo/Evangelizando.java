package br.org.fepb.electra.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_evangelizando")
public class Evangelizando extends Pessoa {

	private static final long serialVersionUID = 7927686865996077792L;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dados_saude")
    private DadosSaude dadosSaude;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dados_familia")
    private DadosFamilia dadosFamilia;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dados_academicos")
    private DadosAcademicos dadosAcademicos;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dados_desv_socioemocional")
	private DadosDesvSocioEmocional dadosDesvSocioEmocional;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dados_sociabilidade")
    private DadosSociabilidade dadosSociabilidade;
	
	public DadosFamilia getDadosFamilia() {
		if(dadosFamilia == null){
			return new DadosFamilia();
		}
		return dadosFamilia;
	}

	public void setDadosFamilia(DadosFamilia dadosFamilia) {
		this.dadosFamilia = dadosFamilia;
	}

	public DadosAcademicos getDadosAcademicos() {
		if(dadosAcademicos == null){
			return new DadosAcademicos();
		}
		return dadosAcademicos;
	}

	public void setDadosAcademicos(DadosAcademicos dadosAcademicos) {
		this.dadosAcademicos = dadosAcademicos;
	}

	public DadosDesvSocioEmocional getDadosDesvSocioEmocional() {
		if(dadosDesvSocioEmocional == null){
			return new DadosDesvSocioEmocional();
		}
		return dadosDesvSocioEmocional;
	}

	public void setDadosDesvSocioEmocional(DadosDesvSocioEmocional dadosDesvSocioEmocional) {
		this.dadosDesvSocioEmocional = dadosDesvSocioEmocional;
	}

	public DadosSociabilidade getDadosSociabilidade() {
		if(dadosSociabilidade == null){
			return new DadosSociabilidade();
		}
		return dadosSociabilidade;
	}

	public void setDadosSociabilidade(DadosSociabilidade dadosSociabilidade) {
		this.dadosSociabilidade = dadosSociabilidade;
	}

	public DadosSaude getDadosSaude() {
		if(dadosSaude == null){
			return new DadosSaude();
		}
		return dadosSaude;
	}

	public void setDadosSaude(DadosSaude dadosSaude) {
		this.dadosSaude = dadosSaude;
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
		Evangelizando other = (Evangelizando) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    
}
