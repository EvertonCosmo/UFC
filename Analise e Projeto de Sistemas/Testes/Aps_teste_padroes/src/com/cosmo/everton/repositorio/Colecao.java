package com.cosmo.everton.repositorio;
import com.cosmo.everton.pessoa.Pessoa;

interface Colecao {
	
	
	public boolean inserir(Pessoa p);
	public boolean remover();
	public boolean remover(int i);
	public boolean atualizar(int i,Pessoa p);
	public boolean  pesquisar(Pessoa p);
	public boolean colecaoEstaVazia();
	public void imprimirDadosColecao();
	public Pessoa retornarObjeto(int i);
}
