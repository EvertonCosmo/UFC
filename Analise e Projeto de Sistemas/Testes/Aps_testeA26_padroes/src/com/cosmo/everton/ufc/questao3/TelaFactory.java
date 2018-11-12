package com.cosmo.everton.ufc.questao3;

import javax.swing.JOptionPane;


public class TelaFactory {

	public TelaLogonIF gerarTela(String banco) {

		if(banco == "" || banco == null) {
			return null;
		}else if(banco.toUpperCase().equals("BRADESCO")) {
			return new Bradesco(banco);
		}else if(banco.toUpperCase().equals("ITAU")) {
			return new Itau(banco);
		}
		
	
		JOptionPane.showMessageDialog(null,"Banco inexistente", "Erro", 0);
		return null;
	}
}
