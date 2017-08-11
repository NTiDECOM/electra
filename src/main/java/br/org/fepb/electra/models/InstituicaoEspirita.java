package br.org.fepb.electra.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	@NotEmpty
	@Column(nullable = false, length = 60)
	private String nome;
	
	private boolean evangeliza;

	@NotEmpty
	@Column(nullable = false, length = 60)
	private String presidente;
	
	@NotEmpty
	@Column(nullable = false, length = 1)
	private String tipo;
	
	@NotEmpty
	@Column(nullable = false, length = 14)
	private String telefone;

	// ****** GETs e SETs ********//
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPresidente() {
		return presidente;
	}

	public boolean isEvangeliza() {
		return evangeliza;
	}

	public void setEvangeliza(boolean evangeliza) {
		this.evangeliza = evangeliza;
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
