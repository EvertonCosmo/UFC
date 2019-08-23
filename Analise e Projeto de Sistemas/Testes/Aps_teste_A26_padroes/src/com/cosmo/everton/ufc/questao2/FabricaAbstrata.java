package com.cosmo.everton.ufc.questao2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public abstract class FabricaAbstrata {

	private static FileInputStream fileInputStreamReader;
	private static final int BRADESCO = Constantes.CODIGO_BRADESCO;
	private static final int ITAU= Constantes.CODIGO_ITAU;
	
	
	static FabricaAbstrata configurarInstancia(int codigoBanco) {
		if(codigoBanco == BRADESCO)
			return new FabricaBradesco();
		else if(codigoBanco ==ITAU)
			return new FabricaItau();
		
		return null;
	}
	
	protected static String arquivoToString(File f) throws IOException {

		fileInputStreamReader = new FileInputStream(f);
		byte[] bytes = new byte[(int)f.length()];
		fileInputStreamReader.read(bytes);
		
		return new String(Base64.getEncoder().encodeToString(bytes));
		
	}
	
	
	abstract MensagemLogon gerarMensagemLogon();
	abstract MensagemLogout gerarLogout();
	
	
	
}
