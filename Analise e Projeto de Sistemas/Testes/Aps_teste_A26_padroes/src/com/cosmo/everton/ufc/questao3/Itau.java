package com.cosmo.everton.ufc.questao3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Itau extends JFrame implements TelaLogonIF{
	private static File f =  new File("itau.png");


	private static final long serialVersionUID = 1L;
	private String nomeBanco;

	public Itau(String nomeBanco) {
		this.nomeBanco = nomeBanco;
		getContentPane().setLayout(null);
		
		
		
		BufferedImage imagem = null;
		try {
			imagem = ImageIO.read(f);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		JLabel labelImage= new JLabel();
		labelImage.setIcon(new ImageIcon(imagem));
		labelImage.setBounds(29, 48, 140, 127);
		getContentPane().add(labelImage);
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(237, 75, 188, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JPasswordField();
		
		textField_2.setColumns(10);
		textField_2.setBounds(237, 166, 188, 19);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(237, 48, 70, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Senha");
		label.setBounds(237, 141, 70, 15);
		getContentPane().add(label);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setBounds(174, 237, 117, 25);
		getContentPane().add(btnNewButton_1);

		//  botão login 
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Obrigado por logar no  " +nomeBanco + ", " + textField_1.getText());
			}
			
		});
		


	}


	private void initComponents(String nomeBanco) {

		setTitle(nomeBanco);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(480, 360);
		setResizable(false);


		

	}

	public void centralizarComponente() {
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dw = getSize();
		setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
	}

	@Override
	public void criarTelaLogon() {
		initComponents(nomeBanco);
		centralizarComponente();
		setVisible(true);


	}


	/* ---  Variáveis ---*/

	private JTextField textField_1;
	private JPasswordField textField_2;
}
