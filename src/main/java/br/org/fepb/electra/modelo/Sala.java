package br.org.fepb.electra.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
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

	@Transient
	private String descricaoCompleta;
	
	@NotNull
	@Column(name="faixa_etaria_anos_inicial")
	private Integer faixaEtariaAnosInicial;

	@NotNull
	@Column(name="faixa_etaria_meses_inicial")
	private Integer faixaEtariaMesesInicial;

	@NotNull
	@Column(name="faixa_etaria_anos_final")
	private Integer faixaEtariaAnosFinal;

	@NotNull
	@Column(name="faixa_etaria_meses_final")
	private Integer faixaEtariaMesesFinal;


	@ManyToOne(fetch = FetchType.EAGER)
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

	@NotNull
	private String periodicidade;
	
	public Sala(Long id){
		setId(id);
	}

	public Sala(){
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getDescricaoCompleta() {
		String descricaoCompleta = null;
		if(descricao!=null && faixaEtariaAnosInicial!=null && faixaEtariaAnosFinal !=null && horaInicio !=null && horaTermino !=null) {
			descricaoCompleta = descricao + " (" + faixaEtariaAnosInicial + " anos e "+ faixaEtariaMesesInicial +" meses até " +
					"" + faixaEtariaAnosFinal + " anos e "+ faixaEtariaMesesFinal +" meses) " +
					diaAula +" - "+ DateUtil.formatarHora(horaInicio) + "-" + DateUtil.formatarHora(horaTermino);
		} else {
			descricaoCompleta = descricao;
		}
		return descricaoCompleta;
	}

	// metodos formatadores para tela
	public String getFaixasEtarias() {
		return this.getFaixaEtariaAnosInicial() +" anos e "+this.getFaixaEtariaMesesInicial()+" meses a "+
				this.getFaixaEtariaAnosFinal() + " anos e "+this.getFaixaEtariaMesesFinal()+" meses";
	}
	
	public String getHorasFormatadas() {
		return DateUtil.formatarHora(this.getHoraInicio()) + " a " + DateUtil.formatarHora(this.getHoraTermino());
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}

	public Integer getFaixaEtariaAnosInicial() {
		return faixaEtariaAnosInicial;
	}

	public void setFaixaEtariaAnosInicial(Integer faixaEtariaAnosInicial) {
		this.faixaEtariaAnosInicial = faixaEtariaAnosInicial;
	}

	public Integer getFaixaEtariaMesesInicial() {
		return faixaEtariaMesesInicial;
	}

	public void setFaixaEtariaMesesInicial(Integer faixaEtariaMesesInicial) {
		this.faixaEtariaMesesInicial = faixaEtariaMesesInicial;
	}

	public Integer getFaixaEtariaAnosFinal() {
		return faixaEtariaAnosFinal;
	}

	public void setFaixaEtariaAnosFinal(Integer faixaEtariaAnosFinal) {
		this.faixaEtariaAnosFinal = faixaEtariaAnosFinal;
	}

	public Integer getFaixaEtariaMesesFinal() {
		return faixaEtariaMesesFinal;
	}

	public void setFaixaEtariaMesesFinal(Integer faixaEtariaMesesFinal) {
		this.faixaEtariaMesesFinal = faixaEtariaMesesFinal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Sala sala = (Sala) o;
		return Objects.equals(descricao, sala.descricao);
	}

	@Override
	public int hashCode() {

		return Objects.hash(descricao);
	}
}
