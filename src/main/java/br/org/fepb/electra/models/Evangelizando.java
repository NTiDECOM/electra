package br.org.fepb.electra.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_evangelizando")
public class Evangelizando extends Pessoa {

	private static final long serialVersionUID = 7927686865996077792L;
	
	//@JoinColumn(name="fk_dados_saude")
    //private DadosSaude dadosSaude;

	@JoinColumn(name="fk_dados_familia")
    private DadosFamilia dadosFamilia;

	@JoinColumn(name="fk_dados_academicos")
    private DadosAcademicos dadosAcademicos;
	
	@JoinColumn(name="fk_dados_desv_socioemocional")
	private DadosDesvSocioEmocional dadosDesvSocioEmocional;
	
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
    
    
}
