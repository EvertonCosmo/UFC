package com.ufc.trabalho.telas;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import com.ufc.trabalho.controle.Fachada;

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
	//
	//	public static double parseDouble(String a) throws ParseException, IOException {
	//
	//		Double d = null;
	//
	//		if(a.contains(",")) {
	//
	//
	//			try {
	//				DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt","BR"));
	//				d = (Double)f.parse(a).doubleValue();
	//				return d;
	//			}catch(Exception e) {
	//				System.err.println("valor inválido. Digite outro, saldo só pode conter números\n");
	//			}
	//
	//
	//		}else {
	//			try {
	//				NumberFormat g = NumberFormat.getInstance();
	//				d = g.parse(a).doubleValue();
	//				return d;
	//			}catch(Exception e) {
	//				System.err.println("valor inválido. Digite outro, saldo só pode conter números\n");
	//				//				Menu.menuInitial();
	//				Fachada f = new Fachada();
	//				f.iniciar();
	//			}
	//		}
	//
	//
	//		return 0;
	//
	//
	//	}
	protected static Double lerDouble(String s) {
		System.out.println(s);
		return  scan.nextDouble();
	}	
	
	

}
