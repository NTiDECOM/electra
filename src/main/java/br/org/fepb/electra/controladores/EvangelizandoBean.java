package br.org.fepb.electra.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.org.fepb.electra.modelo.Bairro;
import br.org.fepb.electra.modelo.DadosAcademicos;
import br.org.fepb.electra.modelo.DadosDesvSocioEmocional;
import br.org.fepb.electra.modelo.DadosFamilia;
import br.org.fepb.electra.modelo.DadosSaude;
import br.org.fepb.electra.modelo.DadosSociabilidade;
import br.org.fepb.electra.modelo.Endereco;
import br.org.fepb.electra.modelo.Evangelizando;
import br.org.fepb.electra.repositorios.EvangelizandoRepositorio;
import br.org.fepb.electra.servicos.BairroService;
import br.org.fepb.electra.servicos.EvangelizandoService;
import br.org.fepb.electra.util.FacesMessages;

//@Named
@Controller("evangelizandoBean")
@ViewScoped
public class EvangelizandoBean extends GenericBean {

	private static final long serialVersionUID = 8390437989517939381L;
	
	@Autowired
	private FacesMessages messages;
	
	@Autowired
	private EvangelizandoService evangelizandoServico;
	
	@Autowired
	private EvangelizandoRepositorio evangelizandoRepositorio;

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
	
	//@NotNull TODO: Analisar obrigatoriedade
	@Autowired
	private Bairro bairroSelecionado;
	
	@Autowired
	private ServletContext servletContext;
	
	/** Método para iniciar a tela de cadastro de evangelizandos */
	@PostConstruct
	public String iniciar() {
		this.bairros = bairroService.listarTodos();
		this.limparVariaveis();
		setState(ESTADO_DE_LISTAGEM);
		return "/pages/Evangelizando";
	}
	
	public String cancelar() {
		limparVariaveis();
		return "/pages/Evangelizando";
	}
	
	public void listar() {
		if ( evangelizandos == null)
			evangelizandos = new ArrayList<Evangelizando>();
		else
			evangelizandos.clear();
		
		//evangelizandos = evangelizandoRepositorio.listarTodos();
		evangelizandos = (List<Evangelizando>) evangelizandoRepositorio.findAll();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		//TODO: configurar spring
		this.evangelizando = new Evangelizando();
		this.evangelizandos = new ArrayList<Evangelizando>();
		this.email1 = "";
		this.email2 = "";
		this.bairroSelecionado = new Bairro();
		this.endereco = new Endereco();
		this.dadosSaude = new DadosSaude();
		this.dadosAcademicos = new DadosAcademicos();
		this.dadosFamilia = new DadosFamilia();
		this.dadosDesvSocioEmocional = new DadosDesvSocioEmocional();
		this.dadosSociabilidade = new DadosSociabilidade();
	}
	
	public void prepararNovoCadastro() {
		this.evangelizando = new Evangelizando();
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
	}
	
	public String salvar() {
		//valida email
		if(!email2.equals(email1)){
			messages.error("Não foi possível confirmar o e-mail, favor preencher novamente.");
			return "";
		} else {
			evangelizando.setEmail(email1);
		}
		//vlaida bairro
		if(endereco !=null && bairroSelecionado !=null){
			//evangelizando.getEndereco().setBairro(new Bairro(idBairro));
			endereco.setBairro(bairroSelecionado);
			evangelizando.setEndereco(endereco);
		}
		evangelizando.setDadosSaude(dadosSaude);
		evangelizando.setDadosAcademicos(dadosAcademicos);
		evangelizando.setDadosFamilia(dadosFamilia);
		evangelizando.setDadosDesvSocioEmocional(dadosDesvSocioEmocional);
		evangelizando.setDadosSociabilidade(dadosSociabilidade);
		
		evangelizando = evangelizandoServico.salvar(evangelizando);
		messages.info("Evangelizando salvo com sucesso! Realize agora a matrícula...");
		listar();
		servletContext.setAttribute("evangelizando", evangelizando);
 		return "/pages/Matricula";
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
		if(evangelizandos == null){
			//return evangelizandoRepositorio.listarTodos();
			return (List<Evangelizando>) evangelizandoRepositorio.findAll();
		}
		return evangelizandos;
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

	public Bairro getBairroSelecionado() {
		return bairroSelecionado;
	}

	public void setBairroSelecionado(Bairro bairroSelecionado) {
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
			//bairros.add(new Bairro(Long.parseLong("1"), "Torre", Long.parseLong("1")));
			//bairros.add(new Bairro(Long.parseLong("2"), "Pedro Gondim", Long.parseLong("1")));
			bairros.add(new Bairro(Long.parseLong("1"), "Torre"));
			bairros.add(new Bairro(Long.parseLong("2"), "Pedro Gondim"));
		}
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public EvangelizandoService getEvangelizandoServico() {
		return evangelizandoServico;
	}

	public EvangelizandoRepositorio getEvangelizandoRepositorio() {
		return evangelizandoRepositorio;
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
	

	
}
