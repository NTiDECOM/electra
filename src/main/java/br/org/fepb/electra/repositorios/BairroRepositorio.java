package br.org.fepb.electra.repositorios;

import java.io.Serializable;

public class BairroRepositorio implements Serializable {

	//public List<Bairro> findAllById(Long id);
	//public List<Bairro> findAllByCidade(Long idCidade);

	/*private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Bairro pesquisarPorId(Long id) {
		return manager.find(Bairro.class, id);
	}
	
	public List<Bairro> listarTodos() {
		return manager.createQuery("from Bairro", Bairro.class).getResultList();
	}
	
	public List<Bairro> listarBairroByCidade(Long idCidade) {
		return manager.createQuery("from Bairro where fk_cidade = :idCidade", Bairro.class)
				.setParameter("idCidade", idCidade).getResultList();
	}
	
	public Bairro salvar(Bairro bairro) {
		return manager.merge(bairro);
	}
	
	public void remover(Bairro bairro) {
		bairro = pesquisarPorId(bairro.getId());
		manager.remove(bairro);
	}*/

	
}
