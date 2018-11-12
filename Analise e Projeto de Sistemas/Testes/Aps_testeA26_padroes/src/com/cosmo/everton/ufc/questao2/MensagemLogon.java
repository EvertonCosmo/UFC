package com.cosmo.everton.ufc.questao2;

import java.util.Base64;

public abstract class MensagemLogon {

	protected String logo;
	private String mensagem;

	protected MensagemLogon(String logo, String mensagem) {
		this.logo = logo;
		this.mensagem = mensagem;
	}

	public String getLogo() {
		return logo;
	}

	
	public String getMensagem() {
		return mensagem;
	}
	
	protected static byte[] stringToByte(String imagemString) { // volta os bytes da imagemString 
		return Base64.getDecoder().decode(imagemString);
	}
	
	
	abstract void mostraTelaGrafica();
	
}
