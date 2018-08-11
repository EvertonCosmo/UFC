package com.cosmo.everton.repositorio;

import java.util.ArrayList;

import com.cosmo.everton.entidades.Bota;

public abstract class Repositorio {
	
	private static ArrayList<Bota> botas = new ArrayList<>();
	
	public static ArrayList<Bota> getBotas() {
		return botas;
	}
	
	public static void adicionar(Bota b) {
		botas.add(b);
	}
	
	
	
	
	
	
	
}
