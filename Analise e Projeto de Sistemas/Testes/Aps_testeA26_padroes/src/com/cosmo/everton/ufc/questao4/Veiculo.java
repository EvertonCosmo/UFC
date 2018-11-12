package com.cosmo.everton.ufc.questao4;

abstract class Veiculo {
	protected WorkShop workShop1;
	protected WorkShop workshop2;
	
	protected Veiculo(WorkShop workShop1, WorkShop workshop2) {
		this.workShop1 = workShop1;
		this.workshop2 = workshop2;
	}
	
	abstract public void fabricar();
}
