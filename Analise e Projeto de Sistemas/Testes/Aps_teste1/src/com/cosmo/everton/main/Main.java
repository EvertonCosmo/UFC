package com.cosmo.everton.main;


import com.cosmo.everton.repositorio.CopadoMundo;


public class Main {
	public static void main(String[] args) throws Exception {
		try {
			CopadoMundo.entrada();
			// CopadoMundo.times();
		}catch(Exception e) {
			System.out.println("necessita de pelo menos dois times");
			System.exit(1);
		}
		

	}
}
