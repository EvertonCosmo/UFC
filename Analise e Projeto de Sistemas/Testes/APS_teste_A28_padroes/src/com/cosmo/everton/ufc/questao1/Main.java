package com.cosmo.everton.ufc.questao1;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		// Exemplo da Ovelha 
		//	Ovelha original = new Ovelha("Dolly"); 
		//Ovelha clonada = original.clone();

		// Exemplo da Parede

		Prototipo p1 = new Parede(10);

		Prototipo p2 = new Parede(30);

		Prototipo list[] = {
				p1,p2,p1.clonar(),p2.clonar()
		};

		for(Prototipo p : list) {
			p.mostraAltura();
		}


	}

}
