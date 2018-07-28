package com.cosmo.everton.entitys;

import java.util.ArrayList;

public abstract class Account{

	private Integer number;
	private String name;
	private double balance;
	private boolean status;
	private String special;
	private double limit;

	private ArrayList<Movement> drives = new ArrayList<>();

	public Account(Integer number, String name, double balance, boolean status, String special, double limit) {
		this.number = number;
		this.name = name;
		this.balance = balance;
		this.status = status;
		this.special = special;
		this.limit = limit;

	}
	public void addMovement(Movement e) {
		drives.add(e);
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public double getLimit() {
		return limit;
	}
	public String getSpecial() {
		return special;
	}
	

	public ArrayList<Movement> getDrives() {
		return drives;
	}



	@Override
	public String toString() {
		String status;
		String specialS;
		
		if(special.equalsIgnoreCase("s")) {
			specialS = "especial";
		}
		else { 
			specialS = "normal";
		}
		
		if(this.status == true) { 
			status = "ativada";
		}
		
		else { 
			status = "desativada";
		}
		
		return "Account [number = " + number + ", name = " + name + ", balance =" + balance + ", status =" + status
				+ ", special = " + specialS + ", limit = " + limit + "]";
	}







}

