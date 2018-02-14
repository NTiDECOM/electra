package br.org.fepb.electra.modelo.autenticacao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import br.org.fepb.electra.modelo.GenericModel;

@Entity
@Table(name = "tb_perfil")
public class Perfil extends GenericModel {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 60, nullable = false, unique = true)
	private String nome;
	
	@Column(length = 255)
	private String descricao;
	
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_perfil_funcionalidade", 
		joinColumns = @JoinColumn(name = "fk_perfil", nullable = false), 
		inverseJoinColumns = @JoinColumn(name = "fk_funcionalidade", nullable = false))
	@OrderBy(value = "id asc")
	private List<Funcionalidade> funcionalidades;

}
