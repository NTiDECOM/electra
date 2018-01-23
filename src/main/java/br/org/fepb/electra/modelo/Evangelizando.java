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
		return dadosFamilia;
	}

	public void setDadosFamilia(DadosFamilia dadosFamilia) {
		this.dadosFamilia = dadosFamilia;
	}

	public DadosAcademicos getDadosAcademicos() {
		return dadosAcademicos;
	}

	public void setDadosAcademicos(DadosAcademicos dadosAcademicos) {
		this.dadosAcademicos = dadosAcademicos;
	}

	public DadosDesvSocioEmocional getDadosDesvSocioEmocional() {
		return dadosDesvSocioEmocional;
	}

	public void setDadosDesvSocioEmocional(DadosDesvSocioEmocional dadosDesvSocioEmocional) {
		this.dadosDesvSocioEmocional = dadosDesvSocioEmocional;
	}

	public DadosSociabilidade getDadosSociabilidade() {
		return dadosSociabilidade;
	}

	public void setDadosSociabilidade(DadosSociabilidade dadosSociabilidade) {
		this.dadosSociabilidade = dadosSociabilidade;
	}

	public DadosSaude getDadosSaude() {
		return dadosSaude;
	}

	public void setDadosSaude(DadosSaude dadosSaude) {
		this.dadosSaude = dadosSaude;
	}

	

    
}
