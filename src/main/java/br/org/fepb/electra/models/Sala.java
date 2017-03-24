package br.org.fepb.electra.models;

import java.time.LocalTime;

import javax.persistence.Entity;

@Entity
public class Sala extends GenericModel {

	private static final long serialVersionUID = -2260190071791535731L;

	private String descricao;
	
	private Integer faixaEtariaInicial;
	
	private Integer faixaEtariaFinal;
	
	private InstituicaoEspirita instituicao;
	
	private LocalTime horaInicio;
	
	private LocalTime horaTermino;

	
	// ****** GETs e SETs ********//
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getFaixaEtariaInicial() {
		return faixaEtariaInicial;
	}

	public void setFaixaEtariaInicial(Integer faixaEtariaInicial) {
		this.faixaEtariaInicial = faixaEtariaInicial;
	}

	public Integer getFaixaEtariaFinal() {
		return faixaEtariaFinal;
	}

	public void setFaixaEtariaFinal(Integer faixaEtariaFinal) {
		this.faixaEtariaFinal = faixaEtariaFinal;
	}

	public InstituicaoEspirita getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoEspirita instituicao) {
		this.instituicao = instituicao;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(LocalTime horaTermino) {
		this.horaTermino = horaTermino;
	}
	
}
