package com.cosmo.everton.main;

import com.cosmo.everton.structure.Trie;


public class Main {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		trie.insert("Cosmo");
		trie.insert("Everton ");
		trie.insert("Crime");
		trie.insert("Antonio");
		trie.insert("Basa");
			
		trie.show();
		System.out.println(trie.search("Cosmo"));
	}

}
