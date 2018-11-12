package com.cosmo.everton.ufc.questao4;

public class Bicicleta extends Veiculo{

	protected Bicicleta(WorkShop workShop1, WorkShop workshop2) {
		super(workShop1, workshop2);
	
	}

	@Override
	public void fabricar() {
		System.out.println("Bicicleta");
		
		workShop1.trabalhar();
		workshop2.trabalhar();
		
	}

}
