package com.cosmo.everton.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cosmo.everton.time.Time;

public abstract class CopadoMundo {	

	private static List <Time> times = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);

	private static void adicionarTime(Time t) {
		times.add(t);
	}
	// mostra toString time
	public static void times(){
		times.forEach(System.out::println);
	}

	public static void entrada() throws Exception {

		String nome;
		String s;
		int t;
		int n;
		int pontos;
		int soma = 0;
		int empates =0;

		s = in.nextLine();
		String[] campos = divide(s);

		t = Integer.parseInt(campos[0]); // número de times
		n = Integer.parseInt(campos[1]); // número de partidas

		

		if(t >= 2 && t<=200 || n >= 2 && n <=Math.pow(10,4)) {
			for(int i=0; i<t; i++) {
				nome = in.next();
				pontos = in.nextInt();
				CopadoMundo.adicionarTime(new Time(nome, pontos));
				soma+=times.get(i).getPontuacao();

			}
		}else {
			throw new Exception();
		}


		in.close();
		empates= (3*n)-soma;

		System.out.println(empates);

	}

	private static String[] divide(String s) {
		String[] campos;
		campos = s.split(" ");
		return campos;

	}


}
