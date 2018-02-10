package br.org.fepb.electra.controladores;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.validation.constraints.NotNull;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.org.fepb.electra.modelo.Evangelizando;
import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.modelo.Matricula;
import br.org.fepb.electra.modelo.Sala;
import br.org.fepb.electra.servicos.InstituicaoEspiritaService;
import br.org.fepb.electra.servicos.MatriculaService;
import br.org.fepb.electra.servicos.SalaService;
import br.org.fepb.electra.util.FacesMessages;

@Controller("matriculaBean")
@ViewScoped
public class MatriculaBean extends GenericBean {

	private static final String FORMATO_ID_ZEROS = "0000";

	private static final long serialVersionUID = 8390437989517939381L;
	
	@Autowired
	private FacesMessages messages;
	
	@Autowired
	private MatriculaService matriculaServico;
	
	@Autowired
	private InstituicaoEspiritaService instituicaoServico;
	
	@Autowired
	private SalaService salaServico;
	
	private List<Matricula> matriculas;
	
	private Matricula matricula;
	
	private Matricula confirmacaoMatricula;
	
	private Evangelizando evangelizando;
	
	@NotNull
	private Long idInstituicao;

	@NotNull
	private Sala salaSelecionada;
	
	@NotNull
	private Boolean evangelizadoAnteriormente;
	
	private String localUltimaEvangelizacao;
	
	private String tempoUltimaEvangelizacao;
	
	private String observacoes;
	
	@Autowired
	private ServletContext servletContext;
	
	@PostConstruct
	public void init(){
		setState(ESTADO_DE_NOVO);
	}
	
	/** Método para iniciar a tela de cadastro de matriculas */
	public String iniciar() {
		this.limparVariaveis();
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Matricula?faces-redirect=true";
	}
	
	public String cancelar() {
		limparVariaveis();
		return "/pages/Evangelizando";
	}
	
	public void listar() {
		if ( matriculas == null)
			matriculas = new ArrayList<Matricula>();
		else
			matriculas.clear();
		
		matriculas = matriculaServico.listarTodos();
		//setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		this.matricula = new Matricula();
		this.matriculas = matriculaServico.listarTodos();
		this.idInstituicao = null;
		this.salaSelecionada = null;
		this.evangelizadoAnteriormente = false;
		this.localUltimaEvangelizacao = "";
		this.tempoUltimaEvangelizacao = "";
		this.observacoes = "";
	}
	
	public void prepararNovoCadastro() {
		this.idInstituicao = null;
		this.salaSelecionada = null;
		this.matricula = new Matricula();
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
	}
	
	public String salvar() {
		if(matricula == null){
			matricula = new Matricula();
		}
		try {
		matricula.setEvangelizando(evangelizando);
		matricula.setSala(salaSelecionada);
		matricula.setEvangelizadoAnteriormente(evangelizadoAnteriormente);
		matricula.setLocalUltimaEvangelizacao(localUltimaEvangelizacao);
		matricula.setTempoUltimaEvangelizacao(tempoUltimaEvangelizacao);
		matricula.setObservacoes(observacoes);
		//gerar numeracao
		matricula.setNumeroMatricula(gerarNumeroMatricula(evangelizando));
		matricula = matriculaServico.salvar(matricula);
		messages.info("Matrícula realizada com sucesso!");
		servletContext.setAttribute("confirmacaoMatricula", matricula);
		listar();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:matriculas-table"));
		this.limparVariaveis();
		} catch (Exception e) {
			e.printStackTrace();
			return "/pages/Matricula";
		}
		return "/pages/ConfirmacaoMatricula";
	}
	
	/**
	 * 
	 * Gera a numeração no formato:
	 * YYYYMMDD + 
	 * 
	 */
	public String gerarNumeroMatricula(Evangelizando evangelizando){
		StringBuilder numeroMatricula = new StringBuilder(); 
			numeroMatricula.append(new SimpleDateFormat("YYYYMMdd").format(evangelizando.getDataNascimento()));
			//numeroMatricula.append(evangelizando.getComoSerChamado().trim().toUpperCase().replaceAll(" ", ""));
			DecimalFormat df = new DecimalFormat(FORMATO_ID_ZEROS);
			numeroMatricula.append(df.format(evangelizando.getId()));
		return numeroMatricula.toString();
	}
	
	public void excluir() {
		matriculaServico.excluir(matricula);
		matricula = null;
		messages.info("Matricula(a) excluído(a) com sucesso!");
		listar();
	}
	
	public List<SelectItem> getInstituicoes() {
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		List<InstituicaoEspirita> lista = instituicaoServico.listarTodos();
		for (InstituicaoEspirita in : lista) {
			retorno.add(new SelectItem(in.getId(), in.getNome()));
		}
		return retorno;
	}
	
	public List<Sala> getSalasPorInstituicao() {
		if ( idInstituicao != null ) {
			return salaServico.listarByInstituicao(idInstituicao);
		}
		return new ArrayList<>();
	}

	public List<Matricula> getMatriculas() {
		if(matriculas == null){
			return matriculaServico.listarTodos();
		}
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Long getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public Sala getSalaSelecionada() {
		return salaSelecionada;
	}

	public void setSalaSelecionada(Sala salaSelecionada) {
		this.salaSelecionada = salaSelecionada;
	}

	public Evangelizando getEvangelizando() {
		if(evangelizando == null){
			this.evangelizando = (Evangelizando) servletContext.getAttribute("evangelizando");
		}
		return evangelizando;
	}

	public void setEvangelizando(Evangelizando evangelizando) {
		this.evangelizando = evangelizando;
	}

	public Matricula getConfirmacaoMatricula() {
		if(confirmacaoMatricula == null){
			this.confirmacaoMatricula = (Matricula) servletContext.getAttribute("confirmacaoMatricula");
		}
		return confirmacaoMatricula;
	}

	public void setConfirmacaoMatricula(Matricula confirmacaoMatricula) {
		this.confirmacaoMatricula = confirmacaoMatricula;
	}

	public Boolean getEvangelizadoAnteriormente() {
		return evangelizadoAnteriormente;
	}

	public void setEvangelizadoAnteriormente(Boolean evangelizadoAnteriormente) {
		this.evangelizadoAnteriormente = evangelizadoAnteriormente;
	}

	public String getLocalUltimaEvangelizacao() {
		return localUltimaEvangelizacao;
	}

	public void setLocalUltimaEvangelizacao(String localUltimaEvangelizacao) {
		this.localUltimaEvangelizacao = localUltimaEvangelizacao;
	}

	public String getTempoUltimaEvangelizacao() {
		return tempoUltimaEvangelizacao;
	}

	public void setTempoUltimaEvangelizacao(String tempoUltimaEvangelizacao) {
		this.tempoUltimaEvangelizacao = tempoUltimaEvangelizacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
}
