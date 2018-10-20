package com.cosmo.everton.repositorio;


import com.cosmo.everton.pessoa.Pessoa;

public class ColecaoPessoa implements Colecao{

	private final static ColecaoPessoa INSTANCE = new  ColecaoPessoa();

	private Pessoa[] dados = new Pessoa[100];  

	private int posicao;

	public ColecaoPessoa() {}

	public Pessoa[] getDados() {
		return dados;
	}

	public void setDados(Pessoa[] dados) {
		this.dados = dados;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public static ColecaoPessoa getInstance() {
		return INSTANCE;
	}

	@Override
	public boolean inserir (Pessoa p) {

		if(!p.validarDocumento()) {
			return false;
		}

		if(posicao < 100 && p != null) {
			dados[posicao++] = p;
			return true;
		}
		
		
		return false;
		
	
		

	}

	@Override
	public boolean remover() {
		System.out.println("remover: " + (posicao-1));
		return remover(posicao-1);


	}

	// OK 
	@Override
	public boolean remover(int i) {

		if(pesquisar(dados[i])) {

			dados[i]=null;
			dados[i] = dados[i+1];
			dados[i+1] = null;

			posicao--;

			return true;
		}


		return false;


	}
	// OK 
	@Override
	public boolean atualizar(int i, Pessoa p) { 
		if(pesquisar(dados[i])) {
			dados[i] = p;
			return true;
		}

		return false;



	}
	// OK 
	@Override
	public boolean pesquisar(Pessoa p) {

		if(colecaoEstaVazia()) {
			return false;
		}

		for(int i=0; i<posicao; i++) {
			if(dados[i].equals(p)) {
				return true;
			}
		}
		System.out.println("objeto nao esta na lista");
		return false;
	}

	//OK 
	@Override
	public boolean colecaoEstaVazia() {
		int k=0;
		for(int i=0; i<posicao; i++) {
			if(dados[i] == null) {
				k++;
			}
		}

		if(k == posicao) {
			System.out.println("lista vazia.");
			return true;

		}

		return false;

	}

	@Override
	public void imprimirDadosColecao() {

		if(colecaoEstaVazia()) {
			return;
		} 

		for(int i=0; i<posicao;i++) {

			System.out.println(dados[i]);
			

		}
		

	}

	@Override
	public Pessoa retornarObjeto(int i) {

		for(Pessoa pessoa : dados) {
			if(pessoa.equals(dados[i])) {
				return pessoa;
			}
		}

		return null;
	}






}
