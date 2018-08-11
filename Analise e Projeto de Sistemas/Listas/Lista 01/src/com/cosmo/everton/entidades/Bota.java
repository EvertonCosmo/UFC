package com.cosmo.everton.entidades;

public class Bota {
	private int tamanho;
	private char lado;
	
	
	public Bota(int tamanho, char lado) {
		this.tamanho = tamanho;
		this.lado = lado;
	}


	public int getTamanho() {
		return tamanho;
	}

	public char getLado() {
		return lado;
	}


	@Override
	public String toString() {
		return "Bota [tamanho=" + tamanho + ", lado=" + lado + "]";
	}


	
	
	
}
