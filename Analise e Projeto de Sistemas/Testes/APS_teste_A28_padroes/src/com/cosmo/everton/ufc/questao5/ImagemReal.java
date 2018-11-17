package com.cosmo.everton.ufc.questao5;

public class ImagemReal implements Imagem{
	
	private String nomeArquivo;
	
	public ImagemReal(String nome) {
		this.nomeArquivo = nome;
		carregar(nome);
	}

	@Override
	public void mostrar() {
		System.out.println("mostrando ... "+nomeArquivo);
		
	}
	public void carregar(String nome) {
		System.out.println("Carregando ... "+nomeArquivo);
		
	}
	
}
