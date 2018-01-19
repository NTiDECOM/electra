package br.org.fepb.electra.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dados_desv_socioemocional")
public class DadosDesvSocioEmocional implements Serializable {
    
	private static final long serialVersionUID = 1035704602387530513L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="matricula")
    private Matricula matricula;

    @Column(name="alegre")
    private Boolean alegre;

    @Column(name="imaginacao_fertil")
    private Boolean imaginacaofertil;

    @Column(name="curioso")
    private Boolean curioso;

    @Column(name="sente_se_inferior")
    private Boolean senteSeInferior;

    @Column(name="relaciona_se_bem_com_proximo")
    private Boolean relacionaSeBemComProximo;

    @Column(name="conversa_bastante")
    private Boolean conversaBastante;

    @Column(name="revela_se_lider")
    private Boolean revelaSeLider;

    @Column(name="triste")
    private Boolean triste;

    @Column(name="irrita_se_facilmente")
    private Boolean irritaSeFacilmente;

    @Column(name="propenso_a_briga")
    private Boolean propensoABriga;

    @Column(name="dificuldade_partilhar")
    private Boolean dificuldadePartilhar;

    @Column(name="impulsivo")
    private Boolean impulsivo;

    @Column(name="inseguro_emocionalmente")
    private Boolean inseguroEmocionalmente;

    @Column(name="ofende_se_facilmente")
    private Boolean ofendeSeFacilmente;

    @Column(name="toma_decisao_sozinho")
    private Boolean tomaDecisaoSozinho;

    @Column(name="medos")
    private String medos;
    
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

	public Boolean getAlegre() {
		return alegre;
	}

	public void setAlegre(Boolean alegre) {
		this.alegre = alegre;
	}

	public Boolean getImaginacaofertil() {
		return imaginacaofertil;
	}

	public void setImaginacaofertil(Boolean imaginacaofertil) {
		this.imaginacaofertil = imaginacaofertil;
	}

	public Boolean getCurioso() {
		return curioso;
	}

	public void setCurioso(Boolean curioso) {
		this.curioso = curioso;
	}

	public Boolean getSenteSeInferior() {
		return senteSeInferior;
	}

	public void setSenteSeInferior(Boolean senteSeInferior) {
		this.senteSeInferior = senteSeInferior;
	}

	public Boolean getRelacionaSeBemComProximo() {
		return relacionaSeBemComProximo;
	}

	public void setRelacionaSeBemComProximo(Boolean relacionaSeBemComProximo) {
		this.relacionaSeBemComProximo = relacionaSeBemComProximo;
	}

	public Boolean getConversaBastante() {
		return conversaBastante;
	}

	public void setConversaBastante(Boolean conversaBastante) {
		this.conversaBastante = conversaBastante;
	}

	public Boolean getRevelaSeLider() {
		return revelaSeLider;
	}

	public void setRevelaSeLider(Boolean revelaSeLider) {
		this.revelaSeLider = revelaSeLider;
	}

	public Boolean getTriste() {
		return triste;
	}

	public void setTriste(Boolean triste) {
		this.triste = triste;
	}

	public Boolean getIrritaSeFacilmente() {
		return irritaSeFacilmente;
	}

	public void setIrritaSeFacilmente(Boolean irritaSeFacilmente) {
		this.irritaSeFacilmente = irritaSeFacilmente;
	}

	public Boolean getPropensoABriga() {
		return propensoABriga;
	}

	public void setPropensoABriga(Boolean propensoABriga) {
		this.propensoABriga = propensoABriga;
	}

	public Boolean getDificuldadePartilhar() {
		return dificuldadePartilhar;
	}

	public void setDificuldadePartilhar(Boolean dificuldadePartilhar) {
		this.dificuldadePartilhar = dificuldadePartilhar;
	}

	public Boolean getImpulsivo() {
		return impulsivo;
	}

	public void setImpulsivo(Boolean impulsivo) {
		this.impulsivo = impulsivo;
	}

	public Boolean getInseguroEmocionalmente() {
		return inseguroEmocionalmente;
	}

	public void setInseguroEmocionalmente(Boolean inseguroEmocionalmente) {
		this.inseguroEmocionalmente = inseguroEmocionalmente;
	}

	public Boolean getOfendeSeFacilmente() {
		return ofendeSeFacilmente;
	}

	public void setOfendeSeFacilmente(Boolean ofendeSeFacilmente) {
		this.ofendeSeFacilmente = ofendeSeFacilmente;
	}

	public Boolean getTomaDecisaoSozinho() {
		return tomaDecisaoSozinho;
	}

	public void setTomaDecisaoSozinho(Boolean tomaDecisaoSozinho) {
		this.tomaDecisaoSozinho = tomaDecisaoSozinho;
	}

	public String getMedos() {
		return medos;
	}

	public void setMedos(String medos) {
		this.medos = medos;
	}
    
    
}
