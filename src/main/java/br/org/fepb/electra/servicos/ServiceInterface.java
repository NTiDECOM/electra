package br.org.fepb.electra.servicos;

import java.util.List;

public interface ServiceInterface<E> {

	public abstract E salvar(E e);
	
	public abstract void excluir(E e);
	
	public abstract List<E> listarTodos();
}
