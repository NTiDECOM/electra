package br.org.fepb.electra.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_evangelizador")
public class Evangelizador extends Pessoa {

	private static final long serialVersionUID = -2485532690960892476L;

	@NotEmpty
	@Column(name = "ocupacao", length = 60)
	private String ocupacao;
	
	@NotEmpty
	@Column(name = "escolaridade", length = 60)
	private String escolaridade;

	@OneToMany(fetch=FetchType.EAGER)
	private List<InstituicaoEspirita> instituicoesEspiritas;
	
	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<InstituicaoEspirita> getInstituicoesEspiritas() {
		return instituicoesEspiritas;
	}

	public void setInstituicoesEspiritas(List<InstituicaoEspirita> instituicoesEspiritas) {
		this.instituicoesEspiritas = instituicoesEspiritas;
	}
	
}
