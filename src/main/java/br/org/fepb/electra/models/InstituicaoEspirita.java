package br.org.fepb.electra.models;

import javax.persistence.Entity;

import br.org.fepb.electra.util.FormatadorBean;
import br.org.fepb.electra.util.StringUtil;

@Entity
public class InstituicaoEspirita extends GenericModel {

	private static final long serialVersionUID = 8405387162636809655L;
	
	public static final String EVANGELIZA_SIM = "S";
	public static final String EVANGELIZA_NAO = "N";
	public static final String TIPO_CASA = "C";
	public static final String TIPO_FEDERATIVA = "F";
	public static final String CASA_ESPIRITA = "Casa Espírita";
	public static final String FEDERATIVA = "Federativa";
	
	private String nome;
	
	private String evangeliza;

	private String presidente;
	
	private String tipo;
	
	private String telefone;

	// ****** GETs e SETs ********//
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEvangeliza() {
		return FormatadorBean.formatarEvangeliza(evangeliza);
	}

	public void setEvangeliza(String evangeliza) {
		this.evangeliza = evangeliza;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public String getTipo() {
		return FormatadorBean.formatarTipoInstituicao(tipo);
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return FormatadorBean.formatarTelefone(telefone);
	}

	public void setTelefone(String telefone) {
		this.telefone = StringUtil.retiraMascaraTelefone(telefone);
	}
	
}
