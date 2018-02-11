package br.org.fepb.electra.controladores;

import br.org.fepb.electra.modelo.*;
import br.org.fepb.electra.servicos.BairroService;
import br.org.fepb.electra.servicos.CidadeService;
import br.org.fepb.electra.servicos.EvangelizandoService;
import br.org.fepb.electra.servicos.ParenteService;
import br.org.fepb.electra.util.FacesMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller("evangelizandoBean")
@ViewScoped
public class EvangelizandoBean extends GenericBean {

	private static final long serialVersionUID = 8390437989517939381L;
	
	@Autowired
	private FacesMessages messages;
	
	@Autowired
	private EvangelizandoService evangelizandoServico;

	@Autowired
	private MatriculaBean matriculaBean;
	
	private List<Evangelizando> evangelizandos;
	
	private Evangelizando evangelizando;
	
	@Autowired
	private Endereco endereco;
	
	@Autowired
	private DadosSaude dadosSaude;
	
	@Autowired
	private DadosAcademicos dadosAcademicos;
	
	@Autowired
	private DadosFamilia dadosFamilia;
	
	@Autowired
	private DadosDesvSocioEmocional dadosDesvSocioEmocional;
	
	@Autowired
	private DadosSociabilidade dadosSociabilidade;
	
	private String email1;
	
	private String email2;
	
	private List<Bairro> bairros;

	@Autowired
	private BairroService bairroService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private ParenteService parenteService;
	
	//@NotNull TODO: Analisar obrigatoriedade
	//@Autowired
	private String bairroSelecionado;
	
	private List<Parente> parentes;
	
	@Autowired
	private ServletContext servletContext;

	private String ufAtual = "PB";

	private String cidadeAtual = "2507507";

	private String naturalidadeSelecionada;

	private String textoPesquisa;

	/** Método para iniciar a tela de cadastro de evangelizandos */
	@PostConstruct
	public String iniciar() {
		this.limparVariaveis();
		listar();
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Evangelizando?faces-redirect=true";
	}

	public String cancelar() {
		limparVariaveis();
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Evangelizando";
	}
	
	public void listar() {
		if ( evangelizandos == null)
			evangelizandos = new ArrayList<Evangelizando>();
		else
			evangelizandos.clear();
		
		evangelizandos = (List<Evangelizando>) evangelizandoServico.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		this.evangelizando = new Evangelizando();
		this.evangelizandos = new ArrayList<Evangelizando>();
		this.email1 = "";
		this.email2 = "";
		this.textoPesquisa = "";
		this.naturalidadeSelecionada = "";
		this.bairroSelecionado = "";
		this.endereco = new Endereco();
		this.dadosSaude = new DadosSaude();
		this.dadosAcademicos = new DadosAcademicos();
		this.dadosFamilia = new DadosFamilia();
		this.dadosDesvSocioEmocional = new DadosDesvSocioEmocional();
		this.dadosSociabilidade = new DadosSociabilidade();
		this.parentes = new ArrayList<>();
		//default: Joao Pessoa/PB
		this.bairros = bairroService.listarPorCidade(Long.parseLong(cidadeAtual));
		//this.bairros = bairroService.listarTodos();
	}

	public String buscarPorDataNasc(){
		setEvangelizandos(null);
		this.evangelizandos = evangelizandoServico.buscarPorDataNasc(textoPesquisa);
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Evangelizando";
	}

	public void prepararNovoCadastro() {
		this.evangelizando = new Evangelizando();
		setState(ESTADO_DE_NOVO);
	}

	public void prepararEdicao() {
		endereco = evangelizando.getEndereco();
		naturalidadeSelecionada = evangelizando.getNaturalidade().getDescricao();
		bairroSelecionado = evangelizando.getEndereco().getBairro().getDescricao();
		dadosSaude = evangelizando.getDadosSaude();
		dadosAcademicos = evangelizando.getDadosAcademicos();
		DadosFamilia familia = evangelizando.getDadosFamilia();
		familia.setParentes(parenteService.listarPorEvangelizando(evangelizando.getId()));
		dadosFamilia = familia;
		parentes = dadosFamilia.getParentes();
		dadosDesvSocioEmocional = evangelizando.getDadosDesvSocioEmocional();
		dadosSociabilidade = evangelizando.getDadosSociabilidade();
		email1 = evangelizando.getEmail();
		email2 = evangelizando.getEmail();
		setState(ESTADO_DE_EDICAO);
	}

	public String prepararEdicaoUrl(Evangelizando evangelizando) {
		prepararEdicao();
		this.evangelizando = evangelizando;
		return "/pages/Evangelizando";
	}

	public String salvar() {
		//valida email
		if(!email2.equals(email1)){
			messages.error("Não foi possível confirmar o e-mail, favor preencher novamente.");
			return "";
		} else {
			evangelizando.setEmail(email1);
		}
		//valida bairro
		if(endereco !=null && bairroSelecionado !=null){
			endereco.setBairro(bairroService.buscarPorDescricao(bairroSelecionado));
			evangelizando.setEndereco(endereco);
		}
		//validade naturalidade
		if(naturalidadeSelecionada !=null){
			evangelizando.setNaturalidade(cidadeService.buscarPorDescricao(naturalidadeSelecionada));
		}
		evangelizando.setDadosSaude(dadosSaude);
		evangelizando.setDadosAcademicos(dadosAcademicos);
		//valida parentes/familia
		List<Parente> parentesTmp = new ArrayList<>();
		if(parentes != null){
			for(Parente pa : parentes){
				if(pa.getNome() != null && !pa.getNome().isEmpty()){
					parentesTmp.add(pa);
				}
			}
			dadosFamilia.setParentes(parentesTmp);
		}
		evangelizando.setDadosFamilia(dadosFamilia);
		evangelizando.setDadosDesvSocioEmocional(dadosDesvSocioEmocional);
		evangelizando.setDadosSociabilidade(dadosSociabilidade);

		String pagina = null;
		//associa evangelizando e estado de tela para etapa seguinte
		if(evangelizando.getId() == null) {
			matriculaBean.setEvangelizando(evangelizando);
			matriculaBean.setState("_novo");
			//servletContext.setAttribute("evangelizando", evangelizando);
			//servletContext.setAttribute("state", "_novo");
			pagina = "/pages/Matricula";
		} else {
			pagina = "/pages/Evangelizando";
		}

		//salva evangelizando
		evangelizando = evangelizandoServico.salvar(evangelizando);
		//atualiza parte com id de evangelizando
		for(Parente p : parentes) {
			p.setEvangelizando(new Evangelizando(evangelizando.getId()));
			parenteService.salvar(p);
		}
		//mensagem de confirmacao
		messages.info("Evangelizando salvo com sucesso! Realize agora a matrícula...");
		//limpar dados
		limparVariaveis();
		//listar
		listar();

		return pagina;
	}
	
	public void excluir() {
		try {
		evangelizandoServico.excluir(evangelizando);
		evangelizando = null;
		messages.info("Evangelizando(a) excluído(a) com sucesso!");
		listar();
		} catch (Exception e) {
			e.printStackTrace();
			messages.error("Existe uma matrícula vinculada. Para remoção completa, primeiramente precisa remover a matrícula dependente");
			
		}
	}
	
	public List<Evangelizando> getEvangelizandos() {
		/*if(evangelizandos == null || evangelizandos.size() == 0){
			return (List<Evangelizando>) evangelizandoServico.listarTodos();
		}*/
		return evangelizandos;
	}

	//autocomplete
	public List<Cidade> completeCidades(String query) {
		List<Cidade> allCidades = cidadeService.listarCidadesPorUF(ufAtual);
		List<Cidade> filteredCidades = new ArrayList<Cidade>();

		for (int i = 0; i < allCidades.size(); i++) {
			Cidade skin = allCidades.get(i);
			if(skin.getDescricao().toLowerCase().startsWith(query.toLowerCase())) {
				filteredCidades.add(skin);
			}
		}

		return filteredCidades;
	}

	//autocomplete
	public List<Bairro> completeBairros(String query) {
		List<Bairro> allBairros = bairroService.listarPorCidade(Long.parseLong(cidadeAtual));
		List<Bairro> filteredBairros = new ArrayList<Bairro>();

		for (int i = 0; i < allBairros.size(); i++) {
			Bairro skin = allBairros.get(i);
			if(skin.getDescricao().toLowerCase().startsWith(query)) {
				filteredBairros.add(skin);
			}
		}

		return filteredBairros;
	}

	public void setEvangelizandos(List<Evangelizando> evangelizandos) {
		this.evangelizandos = evangelizandos;
	}

	public Evangelizando getEvangelizando() {
		return evangelizando;
	}

	public void setEvangelizando(Evangelizando evangelizando) {
		this.evangelizando = evangelizando;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getBairroSelecionado() {
		return bairroSelecionado;
	}

	public void setBairroSelecionado(String bairroSelecionado) {
		this.bairroSelecionado = bairroSelecionado;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public DadosSaude getDadosSaude() {
		return dadosSaude;
	}

	public void setDadosSaude(DadosSaude dadosSaude) {
		this.dadosSaude = dadosSaude;
	}

	public List<Bairro> getBairros() {
		//TODO:
		if(bairros == null){
			bairros = new ArrayList<>();
			//bairros.add(new Bairro(Long.parseLong("1"), "Torre"));
			//bairros.add(new Bairro(Long.parseLong("2"), "Pedro Gondim"));
			//default: Joao Pessoa
			this.bairros = bairroService.listarPorCidade(2507507L);
			//this.bairros = bairroService.listarTodos();

		}
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public EvangelizandoService getEvangelizandoServico() {
		return evangelizandoServico;
	}

	public DadosAcademicos getDadosAcademicos() {
		return dadosAcademicos;
	}

	public DadosFamilia getDadosFamilia() {
		return dadosFamilia;
	}

	public DadosDesvSocioEmocional getDadosDesvSocioEmocional() {
		return dadosDesvSocioEmocional;
	}

	public DadosSociabilidade getDadosSociabilidade() {
		return dadosSociabilidade;
	}

	public List<Parente> getParentes() {
		if(parentes.size() == 0){
			this.parentes.add(new Parente());
		}
		return parentes;
	}

	public void setParentes(List<Parente> parentes) {
		this.parentes = parentes;
	}
	
	public void addParente(){
		this.parentes.add(new Parente());
	}
	
	public void removerParente(){
		this.parentes.remove(parentes.size() -1);
	}

	public String getUfAtual() {
		return ufAtual;
	}

	public void setUfAtual(String ufAtual) {
		this.ufAtual = ufAtual;
	}

	public String getCidadeAtual() {
		return cidadeAtual;
	}

	public void setCidadeAtual(String cidadeAtual) {
		this.cidadeAtual = cidadeAtual;
	}

	public String getNaturalidadeSelecionada() {
		return naturalidadeSelecionada;
	}

	public void setNaturalidadeSelecionada(String naturalidadeSelecionada) {
		this.naturalidadeSelecionada = naturalidadeSelecionada;
	}

    public String getTextoPesquisa() {
        return textoPesquisa;
    }

    public void setTextoPesquisa(String textoPesquisa) {
        this.textoPesquisa = textoPesquisa;
    }
}

