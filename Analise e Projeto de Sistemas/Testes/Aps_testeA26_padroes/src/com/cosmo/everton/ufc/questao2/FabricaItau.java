package com.cosmo.everton.ufc.questao2;

import java.io.File;
import java.io.IOException;

public class FabricaItau extends FabricaAbstrata{
	private static File f = new File("itau.png");
	
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

		return new MensagemLogonItau(enc,"Bem-vindo ao Itau");
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
		
		return new MensagemLogoutItau(enc,"Volte sempre, Itau,<3");
		
	}
	
	
}
