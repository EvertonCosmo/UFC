package com.cosmo.everton.ufc.questao3;

public class CarroLuxo extends CarroDecorator{

	public CarroLuxo(Carro c) {
		super(c);
		
	}
	@Override
	public void montar() {
		super.montar();
		System.out.println("Adicionando recursos do carro de luxo");
	}
}
