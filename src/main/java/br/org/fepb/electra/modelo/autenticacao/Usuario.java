package br.org.fepb.electra.modelo.autenticacao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.fepb.electra.modelo.GenericModel;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends GenericModel {

	private static final long serialVersionUID = 1L;
	
	@Column(name="login")
    private String login;

    @Column(name="senha")
    private String senha;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_cadastro")
    private Date dataCadastro = new Date();
    
    @ManyToOne
    @JoinColumn(name="fk_perfil")
    private Perfil perfil;

}
