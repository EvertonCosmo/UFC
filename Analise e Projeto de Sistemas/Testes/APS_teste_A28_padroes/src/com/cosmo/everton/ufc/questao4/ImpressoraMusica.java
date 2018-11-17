package com.cosmo.everton.ufc.questao4;

public class ImpressoraMusica {
	MusicasColecao musicas;
	
	public ImpressoraMusica(MusicasColecao musicas) {
		this.musicas = musicas;
	}
	public void imprimirMusicas() {
		Interator interator = musicas.criarInterator();
		
		System.out.println("\t\t\t ===  Playlist ===");
		System.out.println();
		while(interator.hasNext()) {
			Musica music = (Musica)interator.next();
			System.out.println(music);
		}
	}
}
