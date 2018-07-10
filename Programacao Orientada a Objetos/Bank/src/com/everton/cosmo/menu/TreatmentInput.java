package com.everton.cosmo.menu;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public abstract class TreatmentInput {
	
	private static Scanner scan = new Scanner(System.in);

	protected static int readDataInteger(String message) {
		System.out.println(message);
		int value = -1;
		try {
			value =scan.nextInt();
		}catch(InputMismatchException e) {
			System.err.println("valor inválido. Digite outro");
		}
		scan.nextLine();
		while(value == -1)
			value = readDataInteger(message);
		return value;
	}


	protected static boolean containsNumber(String s) {

		boolean value=true;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				value=true;
				break;
			}else {
				value = false;
			}
		}
		return value;
	}
	
	protected static String readDataString (String message) {
		System.out.println(message);
		return scan.next();
	}

	protected static double parseDouble(String a) throws ParseException, IOException {
		Double d = null;

		if(a.contains(",")) {
			try {
				DecimalFormat f = (DecimalFormat) DecimalFormat.getInstance(new Locale("pt","BR"));
				d = (Double)f.parse(a).doubleValue();
				System.err.println(d);
				return d;
			}catch(Exception e) {
				System.err.println("valor inválido. Digite outro, saldo só pode conter números\n");
			}


		}else {
			try {
				NumberFormat g = NumberFormat.getInstance();
				d = g.parse(a).doubleValue();
				return d;
			}catch(Exception e) {
				System.err.println("valor inválido. Digite outro, saldo só pode conter números\n");
				Menu.menuInitial();
			}
		}


		return 0;


	}


	protected static boolean readDataBoolean(String message) {
		System.out.println(message);
		return scan.nextBoolean();

	}
	protected static String systemName() {
		String os = System.getProperty("os.name");
		int processors = Runtime.getRuntime().availableProcessors();
		return "Sistema Operacional: "+ os + ", Nº Processadores: "+processors;
	}
	
	protected static void clearScreen() throws IOException {  
		String os = System.getProperty("os.name");
		if(os.contains("Linux")) {
			System.out.println("\033[H\033[2J");  
			System.out.flush();  
		}else {
			Runtime.getRuntime().exec("cls");
		}

	}  
}

