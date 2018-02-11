package br.org.fepb.electra.modelo;

import javax.persistence.*;

@Entity
@Table(name="tb_parente")
public class Parente extends Pessoa {

	private static final long serialVersionUID = -6338182431607243219L;
	
	/**
	 * Herda de pessoa:
	 * nome
	 * contato1
	 * tipocontato1
	 * e-mail
	 * 
	 */
	
	@ManyToOne()
	@JoinColumn(name="fk_evangelizando")
	private Evangelizando evangelizando;

	@Column(name="responsavel")
	private Boolean responsavel;
	
	@Column(name="convive_mesmo_lar")
	private Boolean conviveMesmoLar;
	
	@Transient
	private String responsavelStr;
	
	@Transient
	private String conviveMesmoLarStr;
	
	@Column(name="grau_parentesco")
	private String grauParentesco;
	
	public Parente(){
		//vazio
	}
	
	public Parente(String nome){
		setNome(nome);
	}
	

	/*
	 * Getters and Setters
	 */
	
	public Boolean getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Boolean responsavel) {
		this.responsavel = responsavel;
	}

	public Boolean getConviveMesmoLar() {
		return conviveMesmoLar;
	}

	public void setConviveMesmoLar(Boolean conviveMesmoLar) {
		this.conviveMesmoLar = conviveMesmoLar;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}
	
	public Evangelizando getEvangelizando() {
		if(evangelizando == null){
			return new Evangelizando();
		}
		return evangelizando;
	}

	public void setEvangelizando(Evangelizando evangelizando) {
		this.evangelizando = evangelizando;
	}

	public String getResponsavelStr() {
		return (responsavel!=null && responsavel) ? "SIM" : "NÃO";
	}

	public void setResponsavelStr(String responsavelStr) {
		this.responsavelStr = responsavelStr;
	}

	public String getConviveMesmoLarStr() {
		return (conviveMesmoLar!=null && conviveMesmoLar) ? "SIM" : "NÃO";
	}

	public void setConviveMesmoLarStr(String conviveMesmoLarStr) {
		this.conviveMesmoLarStr = conviveMesmoLarStr;
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
		Parente other = (Parente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
