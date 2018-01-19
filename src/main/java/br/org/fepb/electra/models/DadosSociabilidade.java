package br.org.fepb.electra.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dados_sociabilidade")
public class DadosSociabilidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="matricula")
    private Matricula matricula;

    @Column(name="tem_amigos")
    private Boolean temAmigos;

    @Column(name="tem_momentos_lazer")
    private Boolean temMomentosLazer;

    @Column(name="tipos_lazer")
    private String tiposLazer;

    @Column(name="gosta_de_brincar")
    private Boolean gostaDeBrincar;

    @Column(name="bem_aceito_grupos")
    private Boolean bemAceitoGrupos;

    @Column(name="atividades_favoritas")
    private String atividadesFavoritas;

    @Column(name="reacao_situacao_conflito")
    private String reacaoSituacaoConflito;
    
    @Column(name="observacoes")
    private String observacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Boolean getTemAmigos() {
		return temAmigos;
	}

	public void setTemAmigos(Boolean temAmigos) {
		this.temAmigos = temAmigos;
	}

	public Boolean getTemMomentosLazer() {
		return temMomentosLazer;
	}

	public void setTemMomentosLazer(Boolean temMomentosLazer) {
		this.temMomentosLazer = temMomentosLazer;
	}

	public String getTiposLazer() {
		return tiposLazer;
	}

	public void setTiposLazer(String tiposLazer) {
		this.tiposLazer = tiposLazer;
	}

	public Boolean getGostaDeBrincar() {
		return gostaDeBrincar;
	}

	public void setGostaDeBrincar(Boolean gostaDeBrincar) {
		this.gostaDeBrincar = gostaDeBrincar;
	}

	public Boolean getBemAceitoGrupos() {
		return bemAceitoGrupos;
	}

	public void setBemAceitoGrupos(Boolean bemAceitoGrupos) {
		this.bemAceitoGrupos = bemAceitoGrupos;
	}

	public String getAtividadesFavoritas() {
		return atividadesFavoritas;
	}

	public void setAtividadesFavoritas(String atividadesFavoritas) {
		this.atividadesFavoritas = atividadesFavoritas;
	}

	public String getReacaoSituacaoConflito() {
		return reacaoSituacaoConflito;
	}

	public void setReacaoSituacaoConflito(String reacaoSituacaoConflito) {
		this.reacaoSituacaoConflito = reacaoSituacaoConflito;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
    
    
}
