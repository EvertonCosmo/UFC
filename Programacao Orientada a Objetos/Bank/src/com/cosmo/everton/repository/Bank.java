package com.cosmo.everton.repository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


import com.cosmo.everton.entitys.Account;
import com.cosmo.everton.entitys.Movement;
import com.everton.cosmo.menu.Menu;


public abstract class Bank {

	private static  ArrayList <Account> Accounts = new ArrayList<>();	



	

	public static void createAccount(Account c) {

		try {

			Accounts.add(c);
		}catch(Exception e) {
			System.out.println("Bank.createAccount()");
		}finally {
			System.out.println("Conta criada com sucesso!");
		}
	}



	public static void removeAccount(Integer number) {

		if(Accounts.isEmpty()) {
			System.err.println("Não existem contas cadastradas ainda");
			return;
		}

		Account account = searchAccount(number);
		if(account == null) {
			System.err.println("Conta não encontrada!");
		}
		if(!account.isStatus()) {
			System.err.println("A conta já foi removida/desativada");
			return ;
		}

		account.setStatus(false);
		System.out.println("Conta removida com sucesso");

	}

	public static Account searchAccount(Integer number) {

		if(Accounts.isEmpty()) {
			return null;
		}

		for (Account account : Accounts) {
			if(account.getNumber() == number) {
				return account;
			}
		}

		return null;
	}

	public static void showAccounts() {
		System.out.println("=== CONTAS ATIVAS E INATIVAS === ");

		if(Accounts.isEmpty()) {
			System.err.println("Não possui contas cadastradas ainda");
			return;
		}

		System.out.println("Ativas: ");

		Accounts.forEach(a->{
			if(a.isStatus()) 
				System.out.println(a);
		});

		System.out.println("Inativas: ");

		Accounts.forEach(a->{
			if(!a.isStatus())
				System.out.println(a);
		});

	}


	/*
	 * 	ACCOUNTS OPERATIONS 
	 * 
	 * */
	public static void draw(Account c, double value) throws IllegalArgumentException{


		if (c.getBalance()+c.getLimit() >= value) {
			c.setBalance(c.getBalance()-value);
			c.addMovement(new Movement("saque realizado", value,"débito" ));

		}else {
			throw new IllegalArgumentException();
		}


	}


	public static void deposit(Account c, double value) {

		if(value <= 0) {
			System.out.println("Impossível depositar valor negativo ");
			return;
		}

		c.setBalance(c.getBalance()+value);
		c.addMovement(new Movement("deposito realizado", value,"crédito"));

	}


	public static void balanceIssue(Integer number) {
		String status;
		Account c = searchAccount(number);


		if(c == null ) {
			System.out.println("Erro! conta não encontrada");
			return;
		}


		if(c.isStatus()) 
			status = "ativada";
		else 
			status = "desativada";

		System.out.println("=== EMISSÃO DE SALDO ===  ");
		System.out.println("Conta: "+c.getNumber());
		System.out.println("Titular: "+c.getName());
		System.out.println("Saldo: "+c.getBalance());
		System.out.println("Estado: "+status);

	}
	public static void ExtractIssue(Integer number) {
		Account c = searchAccount(number);

		if(c == null ) {
			System.out.println("Erro! conta não encontrada");
			return;
		}
		System.out.println("=== EMISSÃO DE EXTRATO ===  ");

		if(c.getDrives().isEmpty()) {
			System.out.println("Não existem movimentações nessa conta");
			return;
		}


		c.getDrives().forEach (System.out::println); // show toString for all movement

	}
	public static void transferValue(Account c1,Account c2, double value) {
		//			 1 -> 2 ; draw 1 -> deposit 2 

		if(value <= 0) {
			System.out.println("Impossível transferir valor 0 ou negativo ");
			return;
		}
		
		try {
			draw(c1, value);
			c1.getDrives().remove(c1.getDrives().size()-1);
			c1.getDrives().add(new Movement("Transferência", value, "débito"));
			
		}catch(Exception e) {
			System.err.println("saldo insuficiente na conta de origem");
			return;
		}
		
		deposit(c2, value);
		
		c2.getDrives().remove(c2.getDrives().size()-1); // remove last movement(draw or deposit)
		c2.getDrives().add(new Movement("Transferência", value, "crédito")); // add new movement of transfer

		try {
			Thread.sleep(1200); // wait 1.2 seconds 
		} catch (InterruptedException e) {

			e.printStackTrace();	
		}

		System.out.println("Transferência concluída");

	}

	// checks if there are already accounts in the bank
	public static void checkAccount() {
		if(Accounts.isEmpty()) {
			System.err.println("Não existem contas cadastradas ainda");
			try {
				Menu.menuInitial();
			} catch (ParseException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
