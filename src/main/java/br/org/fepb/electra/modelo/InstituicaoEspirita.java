package br.org.fepb.electra.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.org.fepb.electra.util.FormatadorBean;
import br.org.fepb.electra.util.StringUtil;

import java.util.Objects;

@Entity
@Table(name="tb_instituicao_espirita")
public class InstituicaoEspirita extends GenericModel {

	private static final long serialVersionUID = 8405387162636809655L;
	
	public static final String EVANGELIZA_SIM = "S";
	public static final String EVANGELIZA_NAO = "N";
	public static final String TIPO_CASA = "C";
	public static final String TIPO_FEDERATIVA = "F";
	public static final String CASA_ESPIRITA = "Casa Espírita";
	public static final String FEDERATIVA = "Federativa";

	@Column(name = "codigo_externo")
	private String codigoExterno;

	@NotEmpty
	@Column(nullable = false, length = 60)
	private String nome;
	
	@NotNull
	@Column(nullable = false)
	private Boolean evangeliza;

	@NotEmpty
	@Column(nullable = false, length = 60)
	private String presidente;
	
	@NotEmpty
	@Column(nullable = false, length = 1)
	private String tipo;
	
	@NotEmpty
	@Column(nullable = false, length = 14)
	private String telefone;

	@NotNull
	@Column(name = "quant_espac_fisic_evang")
	private int quantidadeEspacosFisicosEvang;

	public InstituicaoEspirita(){
		//vazio
	}

	// ****** GETs e SETs ********//
	@Override
    public Long getId() {
		return id;
	}

    @Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPresidente() {
		return presidente;
	}

	public Boolean getEvangeliza() {
		return evangeliza;
	}

	public void setEvangeliza(Boolean evangeliza) {
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

	public int getQuantidadeEspacosFisicosEvang() {
		return quantidadeEspacosFisicosEvang;
	}

	public void setQuantidadeEspacosFisicosEvang(int quantidadeEspacosFisicosEvang) {
		this.quantidadeEspacosFisicosEvang = quantidadeEspacosFisicosEvang;
	}

	public String getEvangelizaStr(){
		return evangeliza ? "Sim" : "Nao";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InstituicaoEspirita that = (InstituicaoEspirita) o;
		return Objects.equals(nome, that.nome);
	}

	@Override
	public int hashCode() {

		return Objects.hash(nome);
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
}
