package br.org.fepb.electra.modelo;

import java.util.List;

import javax.persistence.CascadeType;
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

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	@JoinColumn(name="fk_instituicoes_espiritas")
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
		Evangelizador other = (Evangelizador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
