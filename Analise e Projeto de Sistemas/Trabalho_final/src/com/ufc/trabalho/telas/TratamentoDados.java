package com.ufc.trabalho.telas;


import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class TratamentoDados {	
	private static Scanner scan = new Scanner(System.in);

	protected static int lerInteiro(String message) {
		System.out.println(message);
		int value = -1;
		try {
			value =scan.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("valor inválido. Digite outro");
		}
		scan.nextLine(); // "clear" buff 
		while(value == -1)
			value = lerInteiro(message);
		return value;
	}

	protected static String lerString (String message) {
		System.out.println(message);
		return scan.nextLine();
	}
	protected static boolean lerBoolean(String message) {
		System.out.println(message);
		return scan.nextBoolean();
	}
	
	protected static Double lerDouble(String s) {
		System.out.println(s);
		return  scan.nextDouble();
	}	
	
	protected static Integer numeroAleatorio() {
		SecureRandom random = new SecureRandom();
		return random.nextInt(200);
	}

}
