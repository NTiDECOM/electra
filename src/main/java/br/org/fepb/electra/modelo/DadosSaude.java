package br.org.fepb.electra.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dados_saude")
public class DadosSaude  implements Serializable {

	private static final long serialVersionUID = -2928435210349899056L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="possui_alergia")
    private boolean possuiAlergia;

    @Column(name="descricao_alergia")
    private String alergia;

    @Column(name="toma_medicamento_continuo")
    private boolean tomaMedicamentoContinuo;

    @Column(name="medicamento_continuo")
    private String medicamentoContinuo;

    @Column(name="possui_necessidade_especial")
    private boolean possuiNecessidadeEspecial;

    @Column(name="necessidade_especial")
    private String necessidadeEspecial;

    @Column(name="fez_tratamento_espiritual")
    private boolean fezTratamentoEspiritual;

    @Column(name="descricao_tratamento_espiritual")
    private String descricaoTratamentoEspiritual;

    @Column(name="observacoes")
    private String observacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getNecessidadeEspecial() {
		return necessidadeEspecial;
	}

	public void setNecessidadeEspecial(String necessidadeEspecial) {
		this.necessidadeEspecial = necessidadeEspecial;
	}

	public String getDescricaoTratamentoEspiritual() {
		return descricaoTratamentoEspiritual;
	}

	public void setDescricaoTratamentoEspiritual(String descricaoTratamentoEspiritual) {
		this.descricaoTratamentoEspiritual = descricaoTratamentoEspiritual;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean getPossuiAlergia() {
		return possuiAlergia;
	}

	public void setPossuiAlergia(boolean possuiAlergia) {
		this.possuiAlergia = possuiAlergia;
	}

	public boolean getPossuiNecessidadeEspecial() {
		return possuiNecessidadeEspecial;
	}

	public void setPossuiNecessidadeEspecial(boolean possuiNecessidadeEspecial) {
		this.possuiNecessidadeEspecial = possuiNecessidadeEspecial;
	}

	public boolean getFezTratamentoEspiritual() {
		return fezTratamentoEspiritual;
	}

	public void setFezTratamentoEspiritual(boolean fezTratamentoEspiritual) {
		this.fezTratamentoEspiritual = fezTratamentoEspiritual;
	}

	public boolean getTomaMedicamentoContinuo() {
		return tomaMedicamentoContinuo;
	}

	public void setTomaMedicamentoContinuo(boolean tomaMedicamentoContinuo) {
		this.tomaMedicamentoContinuo = tomaMedicamentoContinuo;
	}

	public String getMedicamentoContinuo() {
		return medicamentoContinuo;
	}

	public void setMedicamentoContinuo(String medicamentoContinuo) {
		this.medicamentoContinuo = medicamentoContinuo;
	}

	
	   
}