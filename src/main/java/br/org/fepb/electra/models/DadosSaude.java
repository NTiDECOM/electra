package br.org.fepb.electra.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dados_saude")
public class DadosSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //private boolean possuiAlergia;

    @Column(name="alergia")
    private String alergia;

    //private boolean tomaMedicamentoControlado;

    @Column(name="medicamento_controlado")
    private String medicamentoControlado;

    //private boolean possuiDoencaExigeCuidados;

    @Column(name="doenca_exige_cuidados")
    private String doencaExigeCuidados;

    //private boolean possuiNecessidadeEspecial;

    @Column(name="necessidade_especial")
    private String necessidadeEspecial;

    //private boolean fezTratamentoEspiritual;

    @Column(name="descricao_tratamento_espiritual")
    private String descricaoTratamentoEspiritual;

    @Column(name="local_tratamento_espiritual")
    private String localTratamentoEspiritual;

    @Column(name="motivo_tratamento_espiritual")
    private String motivoTratamentoEspiritual;
    
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

	public String getMedicamentoControlado() {
		return medicamentoControlado;
	}

	public void setMedicamentoControlado(String medicamentoControlado) {
		this.medicamentoControlado = medicamentoControlado;
	}

	public String getDoencaExigeCuidados() {
		return doencaExigeCuidados;
	}

	public void setDoencaExigeCuidados(String doencaExigeCuidados) {
		this.doencaExigeCuidados = doencaExigeCuidados;
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

	public String getLocalTratamentoEspiritual() {
		return localTratamentoEspiritual;
	}

	public void setLocalTratamentoEspiritual(String localTratamentoEspiritual) {
		this.localTratamentoEspiritual = localTratamentoEspiritual;
	}

	public String getMotivoTratamentoEspiritual() {
		return motivoTratamentoEspiritual;
	}

	public void setMotivoTratamentoEspiritual(String motivoTratamentoEspiritual) {
		this.motivoTratamentoEspiritual = motivoTratamentoEspiritual;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	   
}