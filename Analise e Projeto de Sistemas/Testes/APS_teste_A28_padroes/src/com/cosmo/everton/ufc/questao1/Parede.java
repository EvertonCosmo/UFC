package com.cosmo.everton.ufc.questao1;

public class Parede extends Prototipo{
	private int altura;



	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public Parede(int altura){
		this.altura = altura;
	}

	public Parede(Parede parede) {
		this.altura = parede.getAltura();
	}


	@Override
	public Prototipo clonar() {
		System.out.println("clonando ... "+this.getClass().getSimpleName());
		return new Parede(this);
	}

	@Override
	public void mostraAltura() {
		System.out.println("altura: "+ this.altura);


	}


}
