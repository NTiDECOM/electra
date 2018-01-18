package br.org.fepb.electra.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.org.fepb.electra.util.enums.TipoSituacaoMatricula;

/**
 * Criado por Thiago em 20/03/2016
 */
@Entity
@Table(name = "tb_matricula")
public class Matricula extends GenericModel {

	private static final long serialVersionUID = 2530331960419571053L;

	@ManyToOne
    @JoinColumn(name="fk_evangelizando")
    private Evangelizando evangelizando;
    
    @ManyToOne
    @JoinColumn(name="fk_sala")
    private Sala sala;
    
    @Column(name="numero_matricula")
    private String numeroMatricula;
    
    @Column(name="situacao")
    @Enumerated(EnumType.STRING)
    private TipoSituacaoMatricula situacao = TipoSituacaoMatricula.ATIVA;
    
    @NotNull
    @Column(name="evangelizado_anteriormente")
    private Boolean evangelizadoAnteriormente;
    
    @Column(name="local_ultima_evangelizacao")
    private String localUltimaEvangelizacao;
    
    @Column(name="tempo_ultima_evangelizacao")
    private String tempoUltimaEvangelizacao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_cadastro")
    private Date dataCadastro = new Date();
    
    @Column(name="observacoes")
    private String observacoes;

	public Evangelizando getEvangelizando() {
		return evangelizando;
	}

	public void setEvangelizando(Evangelizando evangelizando) {
		this.evangelizando = evangelizando;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public TipoSituacaoMatricula getSituacao() {
		return situacao;
	}

	public void setSituacao(TipoSituacaoMatricula situacao) {
		this.situacao = situacao;
	}

	public Boolean getEvangelizadoAnteriormente() {
		return evangelizadoAnteriormente;
	}

	public void setEvangelizadoAnteriormente(Boolean evangelizadoAnteriormente) {
		this.evangelizadoAnteriormente = evangelizadoAnteriormente;
	}

	public String getLocalUltimaEvangelizacao() {
		return localUltimaEvangelizacao;
	}

	public void setLocalUltimaEvangelizacao(String localUltimaEvangelizacao) {
		this.localUltimaEvangelizacao = localUltimaEvangelizacao;
	}

	public String getTempoUltimaEvangelizacao() {
		return tempoUltimaEvangelizacao;
	}

	public void setTempoUltimaEvangelizacao(String tempoUltimaEvangelizacao) {
		this.tempoUltimaEvangelizacao = tempoUltimaEvangelizacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numeroMatricula == null) ? 0 : numeroMatricula.hashCode());
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
		Matricula other = (Matricula) obj;
		if (numeroMatricula == null) {
			if (other.numeroMatricula != null)
				return false;
		} else if (!numeroMatricula.equals(other.numeroMatricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matricula [evangelizando=" + evangelizando + ", sala=" + sala + ", numeroMatricula=" + numeroMatricula
				+ ", situacao=" + situacao + ", evangelizadoAnteriormente=" + evangelizadoAnteriormente
				+ ", localUltimaEvangelizacao=" + localUltimaEvangelizacao + ", tempoUltimaEvangelizacao="
				+ tempoUltimaEvangelizacao + ", dataCadastro=" + dataCadastro + ", observacoes=" + observacoes + "]";
	}
    
}
