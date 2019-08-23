package com.cosmo.everton.ufc.questao2;


import java.awt.Toolkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class MensagemLogonBradesco extends MensagemLogon {


	public MensagemLogonBradesco(String logo, String mensagem) throws IOException {
		super(logo,mensagem);
	
	}
	
	@Override 
	void mostraTelaGrafica() {
		byte[] imageData = stringToByte(logo);
		FileOutputStream imageOut = null;
		try {
			imageOut = new FileOutputStream(new File("bradesco.png"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			imageOut.write(imageData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			imageOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Icon figure = new ImageIcon(Toolkit.getDefaultToolkit().createImage("bradesco.png"));
		
		JOptionPane.showMessageDialog(null,"Bem-vindo","Bradesco",JOptionPane.PLAIN_MESSAGE,figure);
		System.out.println(this.getMensagem());

	}

}
