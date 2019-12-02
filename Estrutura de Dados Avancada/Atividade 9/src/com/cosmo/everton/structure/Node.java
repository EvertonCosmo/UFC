package com.cosmo.everton.structure;

public class Node {

	private int count; 
	private String word;
	
	public Node(int count, String word) { 
		this.count = count;
		this.word = word;
	}
	
	public int getCount() {
		return count;
	}
	public String getWord() {
		return word;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Node: [Word: ");
		sb.append(word);
		sb.append("], Count: ");
		sb.append(count);
		return sb.toString();
	}

}
