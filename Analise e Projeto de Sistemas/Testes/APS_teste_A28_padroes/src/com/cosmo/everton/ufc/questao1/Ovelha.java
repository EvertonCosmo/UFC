package com.cosmo.everton.ufc.questao1;

public class Ovelha {
	private String nome;

	public Ovelha(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	protected Ovelha clone() throws CloneNotSupportedException {
			return new Ovelha(nome);
	}
	
}
