package com.cosmo.everton.repository;

import java.util.ArrayList;


import com.cosmo.everton.entitys.Account;
import com.cosmo.everton.entitys.Movement;

public abstract class Bank  {

	private static  ArrayList <Account> Accounts = new ArrayList<>();



	public static ArrayList<Account> getAccounts() {
		return Accounts;
	}

	public static void createAccount(Account c) {

		try {

			Accounts.add(c);
		}catch(Exception e) {
			System.out.println("Bank.createAccount()");
		}finally {
			System.out.println("sucess!");
		}
	}



	public static void removeAccount(Integer number) {

		if(Accounts.isEmpty()) {
			System.out.println("Não existem contas cadastradas ainda");
			return;
		}

		Account account = searchAccount(number);
		if(!account.isStatus()) {
			System.out.println("A conta já foi removida/desativada");
			return ;
		}

		account.setStatus(false);
		System.out.println("sucess in remove !");

	}

	// Accounts.remove(account);



	public static Account searchAccount(Integer number) {

		if(Accounts.isEmpty()) {
			//System.out.println("Não possui contas cadastradas");
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
			System.out.println("Não possui contas cadastradas ainda");
			return;
		}

		System.out.println("Ativas: ");
		for (Account account : Accounts) {
			if(account.isStatus()) // ativa
				System.out.println("Número: "+ account.getNumber()+" Titular: "+account.getName());

		}
		System.out.println("Inativas: ");
		for (Account account : Accounts) {
			if(!account.isStatus()) // inativa
				System.out.println("Número: "+ account.getNumber()+" Titular: "+account.getName());
		}

	}

	/*
	 * 	ACCOUNTS OPERATIONS 
	 * 
	 * */


	public static void draw(Account c, double value){


		if(c.getBalance() == 0) { 
			System.out.println("saldo igual a 0, saque indisponível");
			return;
		}


		if(c.getBalance() == 0) {
			if(value <= c.getLimit()) // revisar
				c.setBalance(c.getBalance()+value);

		}

		//if (c.getBalance() >= value) {
		c.setBalance(c.getBalance()-value);

		System.out.println("sucess in draw ");
		c.addMovement(new Movement("saque realizado", value,"crédito" ));

		//	}else
		//	throw new IllegalArgumentException();
		//}catch(Exception e) {
		//	System.out.println("Saldo insuficiente");
		//}
	}


	public static void deposit(Account c, double value) {


		try {


			if(value < c.getBalance() ) {
				c.setBalance(c.getBalance()+value);
				System.out.println("sucess in deposit ");
				c.addMovement(new Movement("deposito realizado", value,"débito"));
			}else
				throw new IllegalArgumentException();
		}catch(Exception e) {
			System.out.println("Saldo insuficiente");
		}
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
		System.out.println("=== EMISSÃO DE EXTRATO ===  ");

		if(c.getDrives().isEmpty()) {
			System.out.println("Não existem movimentações nessa conta");
			return;
		}
		//		System.out.println(c.getDrives()); using collections 

		Object[] a =  c.getDrives().toArray();

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void transferValue(Account c1,Account c2, double value) {
		//			 1 -> 2 ; draw 1 -> deposit 2 


		draw(c1, value);
		deposit(c2, value);

		System.out.println("Sucess in transfer");




	}



}
