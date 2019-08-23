package com.cosmo.everton.ufc.questao4;

public class Main {
	public static void main(String arg[]) {
		Veiculo v1 = new Carro(new Produtor(), new Montadora());
		
		v1.fabricar();
	}

}
