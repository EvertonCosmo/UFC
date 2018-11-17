package com.cosmo.everton.ufc.questao5;

public class ProxyImagem implements Imagem{
	private ImagemReal imagem;
	private String nome;
	
	public ProxyImagem(String nome) {
		this.nome = nome;
	}

	@Override
	public void mostrar() {
		if(imagem == null)
			imagem = new ImagemReal(nome);
		
		imagem.mostrar();
	}
	
}
