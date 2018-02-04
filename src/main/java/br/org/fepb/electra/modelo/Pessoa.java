package br.org.fepb.electra.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@MappedSuperclass
public abstract class Pessoa extends GenericModel {

	private static final long serialVersionUID = 4569195060466766612L;

	@NotEmpty
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@NotEmpty
	@Column(name = "como_ser_chamado", nullable = false, length = 40)
	private String comoSerChamado;

	@NotNull
	@Column(name = "sexo", nullable=false)
	private char sexo;
	
	@Column(name = "raca", nullable=false)
	private String raca;
	
	@Column(name = "cpf", length = 14)
	private String cpf;
	
	@Column(name = "email", length = 60)
	private String email;
	
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@NotEmpty
	@Column(name = "contato1", nullable = false, length = 14)
	private String contato1;
	
	@NotEmpty
	@Column(name = "tipo_contato1", nullable = false)
	private String tipoContato1;
	
	@Column(name = "contato2", length = 14)
	private String contato2;
	
	@Column(name = "tipo_contato2", nullable = false)
	private String tipoContato2;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_endereco")
	private Endereco endereco;
	
	@Column(name="tipo_sanguineo")
	private String tipoSanguineo;
	
	@Column(name = "excluido")
	private Boolean excluido;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComoSerChamado() {
		return comoSerChamado;
	}

	public void setComoSerChamado(String comoSerChamado) {
		this.comoSerChamado = comoSerChamado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getContato1() {
		return contato1;
	}

	public void setContato1(String contato1) {
		this.contato1 = contato1;
	}

	public String getTipoContato1() {
		return tipoContato1;
	}

	public void setTipoContato1(String tipoContato1) {
		this.tipoContato1 = tipoContato1;
	}

	public String getContato2() {
		return contato2;
	}

	public void setContato2(String contato2) {
		this.contato2 = contato2;
	}

	public String getTipoContato2() {
		return tipoContato2;
	}

	public void setTipoContato2(String tipoContato2) {
		this.tipoContato2 = tipoContato2;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
