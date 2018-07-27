package com.cosmo.everton.entitys;



public class Movement {

	private String description;
	private double values;
	private String type; // if credit or debit 


	public Movement(String description, double values, String type) {
		this.description = description;
		this.values = values;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public double getValues() {
		return values;
	}
	public String getType() {
		return type;

	}
	
	@Override
	public String toString() {
		return "Movement [description=" + description + ", values=" + values + ", type=" + type + "]\n";
	}



}
