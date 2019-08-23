package com.cosmo.everton.ufc.questao2;

public class Cliente {
	public static void main(String[] args) {
		
		
		int valor = Constantes.CODIGO_BRADESCO;
		FabricaAbstrata fabrica =FabricaAbstrata.configurarInstancia(valor); 
		
		MensagemLogon mensagemLogon= fabrica.gerarMensagemLogon();
		
		MensagemLogout mensagemLogout = fabrica.gerarLogout();
		
		mensagemLogon.mostraTelaGrafica();
		
		mensagemLogout.mostraTelaGrafica();
		
	}
}
