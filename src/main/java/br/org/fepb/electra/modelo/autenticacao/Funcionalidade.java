package br.org.fepb.electra.modelo.autenticacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.org.fepb.electra.modelo.GenericModel;

@Entity
@Table(name = "tb_funcionalidade")
public class Funcionalidade extends GenericModel {

	private static final long serialVersionUID = 1L;

	@Column(name="codigo")
    private String codigo;

	@Column(name="nome")
    private String nome;

	@Column(name="descricao")
    private String descricao;

	
}
