package com.cosmo.everton.structure;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private  Map<Character, TrieNode> children;
	boolean endOfWord;
	public TrieNode() { 
		children = new HashMap<Character,TrieNode>();
	}
	public TrieNode getChild(char ch) {
		return children.get(ch);
	}
	public TrieNode setChild(char ch) {
		return children.put(ch, new TrieNode());
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}
	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}
	public boolean isEndOfWord() {
		return endOfWord;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Node:[ Words: ");
		sb.append(children);
	    sb.append(" ]\n");
	    return sb.toString();
		
	}


}
