package br.org.fepb.electra.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.org.fepb.electra.daos.EvangelizandoRepositorio;
import br.org.fepb.electra.models.Evangelizando;
import br.org.fepb.electra.models.InstituicaoEspirita;
import br.org.fepb.electra.models.Sala;
import br.org.fepb.electra.services.EvangelizandoService;
import br.org.fepb.electra.services.InstituicaoEspiritaService;
import br.org.fepb.electra.services.SalaService;
import br.org.fepb.electra.util.FacesMessages;

@Named
@ViewScoped
public class EvangelizandoBean extends GenericBean {

	private static final long serialVersionUID = 8390437989517939381L;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private EvangelizandoService evangelizandoServico;
	
	@Inject
	private InstituicaoEspiritaService instituicaoServico;
	
	@Inject
	private SalaService salaServico;
	
	@Inject
	private EvangelizandoRepositorio evangelizandoRepositorio;

	private List<Evangelizando> evangelizandos;
	
	private Evangelizando evangelizando;
	
	private Long idInstituicao;

	private Long idSala;
	
	/** Método para iniciar a tela de cadastro de evangelizandos */
	public String iniciar() {
		this.limparVariaveis();
		return "/pages/Evangelizando";
	}
	
	public void listar() {
		if ( evangelizandos == null)
			evangelizandos = new ArrayList<Evangelizando>();
		else
			evangelizandos.clear();
		
		evangelizandos = evangelizandoRepositorio.listarTodos();
		setState(ESTADO_DE_LISTAGEM);
	}
	
	private void limparVariaveis() {
		this.evangelizando = new Evangelizando();
		this.evangelizandos = new ArrayList<Evangelizando>();
		this.idInstituicao = null;
		this.idSala = null;
	}
	
	public void prepararNovoCadastro() {
		this.idInstituicao = null;
		this.idSala = null;
		evangelizando = new Evangelizando();
		setState(ESTADO_DE_NOVO);
	}
	
	public void prepararEdicao() {
		Sala sala = salaServico.listarById(evangelizando.getIdSala());
		idInstituicao = sala.getIdInstituicao();
		idSala = sala.getId();
	}
	
	public void salvar() {
		evangelizando.setIdSala(idSala);
		evangelizandoServico.salvar(evangelizando);
		messages.info("Evangelizando salvo com sucesso!");
		listar();
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		evangelizandoServico.excluir(evangelizando);
		evangelizando = null;
		messages.info("Evangelizando(a) excluído(a) com sucesso!");
		listar();
	}
	
	public List<SelectItem> getInstituicoes() {
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		for (InstituicaoEspirita in : instituicaoServico.listarTodos()) {
			retorno.add(new SelectItem(in.getId(), in.getNome()));
		}
		return retorno;
	}
	
	public List<SelectItem> getSalasPorInstituicao() {
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		if ( idInstituicao != null ) {
			for (Sala in : salaServico.listarByInstituicao(idInstituicao)) {
				retorno.add(new SelectItem(in.getId(), in.getDescricao()));
			}
		}
		return retorno;
	}

	public List<Evangelizando> getEvangelizandos() {
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

	public Long getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}
	
}
