package com.cosmo.everton.ufc.questao3;

public class Main {
	public static void main(String args[]) {
		Carro carroSport = new CarroSport(new CarroSimples());
		carroSport.montar();
		Carro luxo = new CarroSport(new CarroLuxo(new CarroSimples()));
		luxo.montar();
	}
}
