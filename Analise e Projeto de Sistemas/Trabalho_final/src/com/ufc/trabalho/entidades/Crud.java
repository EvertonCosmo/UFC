package com.ufc.trabalho.entidades;

public interface Crud {
	
	public void adicionar(Object obj);
	public void remover(Integer codigo);
	public Object pesquisar(Object obj);
	public void atualizar();
	
}
