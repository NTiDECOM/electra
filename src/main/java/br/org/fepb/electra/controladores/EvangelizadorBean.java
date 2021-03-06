package br.org.fepb.electra.controladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.validation.constraints.NotNull;

import br.org.fepb.electra.modelo.Endereco;
import org.primefaces.event.DragDropEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.org.fepb.electra.modelo.Evangelizador;
import br.org.fepb.electra.modelo.InstituicaoEspirita;
import br.org.fepb.electra.servicos.EvangelizadorService;
import br.org.fepb.electra.servicos.InstituicaoEspiritaService;
import br.org.fepb.electra.util.FacesMessages;

@Controller("evangelizadorBean")
@ViewScoped
public class EvangelizadorBean extends GenericBean {

	private static final long serialVersionUID = -1745521686277227026L;

    @Autowired
    private ServletContext servletContext;

	@Autowired
	private FacesMessages messages;
	
	@Autowired
	private EvangelizadorService evangelizadorService;

	@Autowired
	private InstituicaoEspiritaService instituicaoEspiritaService;

	private List<Evangelizador> evangelizadores;
	
	private Evangelizador evangelizador;
	
	private List<InstituicaoEspirita> instituicoes;
	
	private String email1;
	
	private String email2;

	@Autowired
	private Endereco endereco;
	
	private List<InstituicaoEspirita> droppedInstituicoes;
	
	@NotNull
	private InstituicaoEspirita selectedInstituicao;
	
	/** Método para iniciar a tela de cadastro de evangelizadores */
	@PostConstruct
	public String iniciar() {
		this.limparVariaveis();
		this.instituicoes = instituicaoEspiritaService.listarTodos();
		this.droppedInstituicoes = new ArrayList<>();
		return "/pages/Evangelizador";
	}
	
	public void listar() {
		limparVariaveis();
		evangelizadores = (List<Evangelizador>) evangelizadorService.listarTodos();
	}
	
	public void cancelar() {
		limparVariaveis();
	}
	
	private void limparVariaveis() {
		setState(ESTADO_DE_LISTAGEM);
		this.evangelizador = new Evangelizador();
		this.instituicoes = null;
		this.endereco = new Endereco();
		this.droppedInstituicoes = null;
		this.selectedInstituicao = null;
		this.evangelizadores = (List<Evangelizador>) evangelizadorService.listarTodos();
		this.email1 = "";
		this.email2 = "";
	}
	
	public void prepararNovoCadastro() {
		evangelizador = new Evangelizador();
		setState(ESTADO_DE_NOVO);
	}
	
	public void salvar() {
		//valida email
		if(!email2.equals(email1)){
			messages.error("Não foi possível confirmar o e-mail, favor preencher novamente.");
			return;
		} else {
			evangelizador.setEmail(email1);
		}
		if(droppedInstituicoes == null || droppedInstituicoes.isEmpty()){
			messages.error("Instituição Espírita não pode ser nula ou vazio, arraste para selecionar");
			return;
		}
		if(!droppedInstituicoes.isEmpty()){
			evangelizador.setInstituicoesEspiritas(droppedInstituicoes);
		}
		if(endereco != null){
			evangelizador.setEndereco(endereco);
		}
		evangelizadorService.salvar(evangelizador);
		messages.info("Evangelizador salvo com sucesso!");
        servletContext.setAttribute("state", "_novo");
        atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm"));
		//limpar dados
		limparVariaveis();
		//listar
		listar();
		atualizarCamposDaTela(Arrays.asList("frm:msgs", "frm:evangelizadores-table"));

	}
	
	public void prepararEdicao() {
		droppedInstituicoes = evangelizador.getInstituicoesEspiritas();
		instituicoes = instituicaoEspiritaService.listarTodos();
		endereco = evangelizador.getEndereco() != null ? evangelizador.getEndereco() : null;
		email1 = evangelizador.getEmail();
		email2 = evangelizador.getEmail();
		if(droppedInstituicoes!=null && instituicoes !=null){
			List<InstituicaoEspirita> instTemp = new ArrayList<>();
			for(InstituicaoEspirita ie : instituicoes){
				if(!droppedInstituicoes.contains(ie)){
					instTemp.add(ie);
				}
			}
			//instituicoes.removeAll(droppedInstituicoes);
			instituicoes.clear();
			instituicoes.addAll(instTemp);
		}
		setState(ESTADO_DE_EDICAO);
	}
	
	public void excluir() {
		evangelizadorService.excluir(evangelizador);
		evangelizador = null;
		messages.info("Evangelizador(a) excluído(a) com sucesso!");
		listar();
	}

	public List<InstituicaoEspirita> getInstituicoes() {
		if(instituicoes == null){
			instituicoes = instituicaoEspiritaService.listarTodos();
		}
		return instituicoes;
	}
	
    public void onInstituicaoDrop(DragDropEvent ddEvent) {
        InstituicaoEspirita instituicaoEspirita = ((InstituicaoEspirita) ddEvent.getData());
        if(droppedInstituicoes == null){
        	droppedInstituicoes = new ArrayList<>();
        }
        droppedInstituicoes.add(instituicaoEspirita);
        selectedInstituicao = instituicaoEspirita;
        instituicoes.remove(instituicaoEspirita);
    }
    
    public void cancelInstituicaoDrop() {
    	droppedInstituicoes.clear();
    	selectedInstituicao = null;
    	instituicoes = instituicaoEspiritaService.listarTodos();
      
    }

	public String getMaskContato1() {
		if(this.evangelizador.getTipoContato1()!=null &&
				this.evangelizador.getTipoContato1().equalsIgnoreCase("RESIDENCIAL")){
			return "(99)9999-9999";
		} else {
			return "(99)99999-9999";
		}
	}

	public List<Evangelizador> getEvangelizadores() {
		if(evangelizadores == null || evangelizadores.size() == 0){
			return (List<Evangelizador>) evangelizadorService.listarTodos();
		}
		return evangelizadores;
	}

	public void setEvangelizadores(List<Evangelizador> evangelizadores) {
		this.evangelizadores = evangelizadores;
	}

	public Evangelizador getEvangelizador() {
		return evangelizador;
	}

	public void setEvangelizador(Evangelizador evangelizador) {
		this.evangelizador = evangelizador;
	}

	public List<InstituicaoEspirita> getDroppedInstituicoes() {
		return droppedInstituicoes;	
	}

	public void setDroppedInstituicoes(List<InstituicaoEspirita> droppedInstituicoes) {
		this.droppedInstituicoes = droppedInstituicoes;
	}

	public InstituicaoEspirita getSelectedInstituicao() {
		return selectedInstituicao;
	}

	public void setSelectedInstituicao(InstituicaoEspirita selectedInstituicao) {
		this.selectedInstituicao = selectedInstituicao;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
