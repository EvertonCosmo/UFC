package com.cosmo.everton.ufc.questao2;

public class FacadeTelefone {
	private Asus zenfone3;
	private IPhone iphone;
	private Xiaomi redmi;

	
	public FacadeTelefone() {
		zenfone3 = new Asus();
		iphone = new IPhone();
		redmi = new  Xiaomi();
		
		
	}
	public void construirApple() {
		 System.out.println(iphone.construir());
	}
	public void construirXiaomi() {
		 System.out.println(redmi.construir());
	}
	public void construirAsus() {
		System.out.println(zenfone3.construir());
	}
}

