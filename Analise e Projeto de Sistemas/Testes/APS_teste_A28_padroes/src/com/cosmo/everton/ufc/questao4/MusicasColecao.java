package com.cosmo.everton.ufc.questao4;

public class MusicasColecao implements Colecao{

	private int numeroItens = 0;
	Musica[] listaMusicas;
	private static final int MAX = 5;

	public MusicasColecao() {
		listaMusicas = new Musica[MAX];
	}


	public void adicionar(Musica musica) {
		if(numeroItens >= MAX) 
			System.err.println("limite excedido");
		else {
			listaMusicas[numeroItens]=musica;
			numeroItens++;
		}
	}
	
	@Override
	public Interator criarInterator() {
		return new MusicasInterator(listaMusicas);
	}



}
