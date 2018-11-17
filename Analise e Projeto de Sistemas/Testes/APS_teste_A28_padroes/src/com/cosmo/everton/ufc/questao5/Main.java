package com.cosmo.everton.ufc.questao5;

public class Main {
	public static void main(String args[]) {
		Imagem imagem = new ProxyImagem("123.png");
		
		imagem.mostrar();
		System.out.println(" ");
		imagem.mostrar();
	}
}
