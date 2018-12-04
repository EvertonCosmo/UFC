package com.ufc.trabalho.telas;

import java.util.Scanner;

import com.ufc.trabalho.controle.Command;
import com.ufc.trabalho.controle.Fachada;
import com.ufc.trabalho.controle.Invoker;


public class Menu implements Command{

	private static Scanner scan = new Scanner(System.in);

	@Override
	public void execute() {
		
		Fachada.carregar();
		
		int opcao = 0;
		do {
			
		System.out.println("||=======================================||");
		System.out.println("||    === BLACK FRIDAY(PERFUMES) ====    ||");
		System.out.println("|| (1) -> CADASTRAR                      ||");
		System.out.println("|| (2) -> REMOVER                        ||");
		System.out.println("|| (3) -> COMPRAR                        ||");
		System.out.println("|| (4) -> EXIT       	                 ||");
		System.out.println("||=======================================||");
		System.out.print(">> ");
		opcao = scan.nextInt();
		switch(opcao) {
		case 1:
			Fachada.cadastrar();break;
		case 2:
			
		case 3:
			Fachada.comprar();break;
		case 4: 
//			Fachada. 
		
		case 5:
			
		case 7: 
			Runtime.getRuntime().exit(1);
		}
				
		}while(opcao != 0);
	}
	
	
}
