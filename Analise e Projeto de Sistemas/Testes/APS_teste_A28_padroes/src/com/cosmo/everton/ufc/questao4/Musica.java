package com.cosmo.everton.ufc.questao4;

public class Musica {
	private String nome;
	private String artista;
	private String ano;
	
	public  Musica(String nome, String artista, String ano) {
		this.nome = nome;
		this.artista = artista;
		this.ano = ano;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Musica: nome=");
		builder.append(nome);
		builder.append(", artista=");
		builder.append(artista);
		builder.append(", ano=");
		builder.append(ano);
		return builder.toString();
	}
	
	
	
}
