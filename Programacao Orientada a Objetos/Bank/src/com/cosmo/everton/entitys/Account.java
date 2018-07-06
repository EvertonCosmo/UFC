package com.cosmo.everton.entitys;

import java.util.ArrayList;

public class Account{

	private Integer number;
	private String name;
	private double balance;
	private boolean status;
	private boolean special;
	private double limit;

	private ArrayList<Movement> drives = new ArrayList<>();

	public Account(Integer number, String name, double balance, boolean status, boolean special, double limit) {
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

	public ArrayList<Movement> getDrives() {
		return drives;
	}



	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", balance=" + balance + ", status=" + status
				+ ", special=" + special + ", limit=" + limit + "]";
	}







}

