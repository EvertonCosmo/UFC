package com.cosmo.everton.pessoa;

public abstract class Pessoa {
	
	private String nome;

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	
	
	public abstract boolean validarDocumento();
	
	abstract int calcularIdade();
	
	
}
