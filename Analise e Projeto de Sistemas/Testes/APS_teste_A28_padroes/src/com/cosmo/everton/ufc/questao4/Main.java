package com.cosmo.everton.ufc.questao4;

public class Main {
	public static void main(String args[]) {
		Musica Angra = new Musica("Carry ON", "Angra", "2008");
		Musica datphoria = new Musica("My own enemy", "Datphoria", "2010");
		Musica Twenty = new Musica("Stressed Out", "Twenty One Pilots", "2011");
	
		MusicasColecao mc = new MusicasColecao();
		mc.adicionar(Angra);
		mc.adicionar(datphoria);
		mc.adicionar(Twenty);
		
		ImpressoraMusica impm = new ImpressoraMusica(mc);
		impm.imprimirMusicas();
	}
}
