package com.cosmo.everton.time;

public class Time {
	private String nome;
	private int pontuacao;


	public Time(String nome, int pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public String toString() {
		return "Time [nome=" + nome + ", pontuacao=" + pontuacao + "]";
	}

	

}
