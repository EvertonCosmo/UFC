package com.cosmo.everton.ufc.questao2;


import java.io.File;
import java.io.IOException;



public class FabricaBradesco extends FabricaAbstrata {
	private static File f = new File("bradesco.png");
	
	
	@Override
	MensagemLogon gerarMensagemLogon() {
		String enc = null;
		try {
			enc = arquivoToString(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			enc = arquivoToString(f);
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			
			return new MensagemLogonBradesco(enc,"Bem-vindo ao Bradesco");
			
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;

	}

	@Override
	MensagemLogout gerarLogout() {
		String enc = null;
		try {
			enc = arquivoToString(f);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			enc = arquivoToString(f);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return new MensagemLogoutBradesco(enc,"Volte sempre, Bradesco,<3");

	}
}
