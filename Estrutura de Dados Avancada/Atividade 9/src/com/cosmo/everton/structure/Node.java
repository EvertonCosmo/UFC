package com.cosmo.everton.structure;

public class Node implements Comparable<Node>{

	private Integer count; 
	private String word;
	
	public Node(int count, String word) { 
		this.count = count;
		this.word = word;
	}
	
	public Integer getCount() {
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
		sb.append("], times: ");
		sb.append(count);
		return sb.toString();
	}

	@Override
	public int compareTo(Node o) {
		if(this.count > o.getCount()) return 1;
		if(this.count < o.getCount()) return -1;
		return 0;
	}

}
