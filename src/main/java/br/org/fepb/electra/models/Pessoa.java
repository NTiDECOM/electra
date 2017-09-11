package br.org.fepb.electra.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class Pessoa extends GenericModel {

	private static final long serialVersionUID = 4569195060466766612L;

	@NotEmpty
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;

	@NotEmpty
	@Column(name = "como_chamado", nullable = false, length = 40)
	private String comoSerChamado;
	
	@Column(name = "cpf", length = 14)
	private String cpf;
	
	@Column(name = "email", length = 60)
	private String email;
	
	//@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	//@NotEmpty
	@Column(name = "telefone1", nullable = false, length = 14)
	private String telefone1;
	
	@Column(name = "telefone2", length = 14)
	private String telefone2;

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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

}
