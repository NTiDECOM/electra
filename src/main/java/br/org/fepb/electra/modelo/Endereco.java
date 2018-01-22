package br.org.fepb.electra.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco extends GenericModel implements Serializable  {
    
	private static final long serialVersionUID = -2918484366260036052L;

	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer id;

    @Column(name="logradouro")
    private String logradouro;

    @Column(name="numero")
    private String numero;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_bairro")
    private Bairro bairro;

    @Column(name="cep")
    private String cep;

    @Column(name="complemento")
    private String complemento;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
    
	
    
}