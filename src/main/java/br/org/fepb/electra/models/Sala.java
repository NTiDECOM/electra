package br.org.fepb.electra.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.org.fepb.electra.util.DateUtil;

@Entity
@Table(name="tb_sala")
public class Sala extends GenericModel {

	private static final long serialVersionUID = -2260190071791535731L;

	@NotEmpty
	@Column(length = 255, nullable=true)
	private String descricao;
	
	@NotNull
	@Column(name="faixa_etaria_inicial")
	private Integer faixaEtariaInicial;
	
	@NotNull
	@Column(name="faixa_etaria_final")
	private Integer faixaEtariaFinal;
	
	@ManyToOne
    @JoinColumn(name="fk_instituicao")
	private InstituicaoEspirita instituicao;
	
	@NotEmpty
	@Column(name="dia_aula")
	private String diaAula;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	@Column(name="hora_inicio")
	private Date horaInicio;
	
	@NotNull
	@Temporal(TemporalType.TIME)
	@Column(name="horario_termino")
	private Date horaTermino;
	
	public Sala(Long id){
		setId(id);
	}

	public Sala(){
		//vazio
	}
	
	// ****** GETs e SETs ********//
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getFaixaEtariaInicial() {
		return faixaEtariaInicial;
	}

	public void setFaixaEtariaInicial(Integer faixaEtariaInicial) {
		this.faixaEtariaInicial = faixaEtariaInicial;
	}

	public Integer getFaixaEtariaFinal() {
		return faixaEtariaFinal;
	}

	public void setFaixaEtariaFinal(Integer faixaEtariaFinal) {
		this.faixaEtariaFinal = faixaEtariaFinal;
	}

	public InstituicaoEspirita getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoEspirita instituicao) {
		this.instituicao = instituicao;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getDiaAula() {
		return diaAula;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;
	}

	// metodos formatadores para tela
	public String getFaixasEtarias() {
		return this.getFaixaEtariaInicial() +" a "+ this.getFaixaEtariaFinal() + " anos";
	}
	
	public String getHorasFormatadas() {
		return DateUtil.formatarHora(this.getHoraInicio()) + " a " + DateUtil.formatarHora(this.getHoraTermino());
	}
}
