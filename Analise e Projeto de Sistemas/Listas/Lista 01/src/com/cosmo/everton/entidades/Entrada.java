package com.cosmo.everton.entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import com.cosmo.everton.repositorio.Repositorio;

public abstract class Entrada {

	private static Scanner in = new Scanner(System.in);


	public static void iniciar() {

		int qtdBotas = 0;
		do {
			qtdBotas = lerInteiro("Digite a quantidade de botas: ");

		}while(qtdBotas%2==1 || qtdBotas<2 || qtdBotas>Math.pow(10,4));


		int tamanho = 0;
		for(int i = 0; i<qtdBotas;i++) {
			
			do {
				tamanho = lerInteiro("Digite o tamanho: ");
			}while(tamanho<30 || tamanho>60);

			char lado;
			
			do {
				lado = lerString("Digite o lado: ").charAt(0);
			}while(!(lado =='D' || lado=='E'));

			Repositorio.adicionar(new Bota(tamanho, lado));
			
			

		}
		contaPares();
//		Repositorio.mostrar();
	}

	public static void contaPares() {
		ArrayList<Bota> array = Repositorio.getBotas();
		array.sort(Comparator.comparing(b->b.getTamanho()));
		
	
		int pares =0;
		for(int i=0; i< array.size();i++) {
			for(int j=i; j<array.size(); j++) {
				
				if(array.get(i).getTamanho() == array.get(j).getTamanho() && array.get(i).getLado() != array.get(j).getLado()) {
					System.out.println(array.get(i) + " outro "+array.get(j) );
					pares++;
					
					//System.out.println();
				}else {
					array.remove(i);
				}
			}
		}
		System.out.println(pares);
		//Repositorio.mostrar();
	}
	
	
	private static int lerInteiro(String msg) {
		System.out.println(msg);
		return in.nextInt();
	}
	
	private static String lerString(String msg) {
		System.out.println(msg);
		return in.next();
	}


}
