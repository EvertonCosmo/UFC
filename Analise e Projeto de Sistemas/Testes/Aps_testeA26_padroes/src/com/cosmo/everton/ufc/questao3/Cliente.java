package com.cosmo.everton.ufc.questao3;

public class Cliente {
	
	public static void main(String[] args) {
		
			TelaFactory factory  = new TelaFactory();
			// Constantes.BRADESCO_STRING
			// Constantes.ITAU_STRING
			
			TelaLogonIF telalogon = factory.gerarTela(Constantes.ITAU_STRING);
			
			telalogon.criarTelaLogon();
	}
}
