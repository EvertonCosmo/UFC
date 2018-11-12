package com.cosmo.everton.ufc.questao4;

public class Carro extends Veiculo {

	
	
	protected Carro(WorkShop workShop1, WorkShop workshop2) {
		super(workShop1, workshop2);
		
	}

	@Override
	public void fabricar() {
		System.out.println("Carro ");
		
		workShop1.trabalhar();
		workshop2.trabalhar();
		
	}

}
