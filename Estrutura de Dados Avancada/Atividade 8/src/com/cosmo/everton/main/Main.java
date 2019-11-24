package com.cosmo.everton.main;

import com.cosmo.everton.structure.Trie;
import com.cosmo.everton.util.FileManager;


public class Main {

	public static void main(String[] args) {
		
		Trie trie= new Trie();
		
//		FileManager.readFile("arquivo2_ASCII.txt",trie);
		FileManager.readFile("arquivo1_cadeias.txt",trie);
		trie.show(trie.getRoot());
		System.out.println(trie.search("Indio"));
	
	}

}
