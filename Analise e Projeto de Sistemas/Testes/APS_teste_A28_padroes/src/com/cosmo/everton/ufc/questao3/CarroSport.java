package com.cosmo.everton.ufc.questao3;

public class CarroSport extends CarroDecorator{

	public CarroSport(Carro c) {
		super(c);
	}
	@Override
	public void montar() {
		super.montar();
		System.out.println("Adicionando recursos do carro esportivo...");
	}
}
