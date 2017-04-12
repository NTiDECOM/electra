package br.org.fepb.electra.models;

import java.util.Date;

import javax.persistence.Entity;

import br.org.fepb.electra.util.DateUtil;

@Entity
public class Sala extends GenericModel {

	private static final long serialVersionUID = -2260190071791535731L;

	private String descricao;
	
	private Integer faixaEtariaInicial;
	
	private Integer faixaEtariaFinal;
	
	private Long idInstituicao;
	
	private Date horaInicio;
	
	private Date horaTermino;

	
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

	public Long getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
		this.horaTermino = horaTermino;
	}
	
	
	// metodos formatadores para tela
	public String getFaixasEtarias() {
		return this.getFaixaEtariaInicial() +" a "+ this.getFaixaEtariaFinal() + " anos";
	}
	
	public String getHorasFormatadas() {
		return DateUtil.formatarHora(this.getHoraInicio()) + " a " + DateUtil.formatarHora(this.getHoraTermino());
	}
}
