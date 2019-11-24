package com.cosmo.everton.structure;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private final Map<Character, TrieNode> children = new HashMap<>();
	private boolean endOfWord;
	
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
		return children.values().toString();
		
	}


}
