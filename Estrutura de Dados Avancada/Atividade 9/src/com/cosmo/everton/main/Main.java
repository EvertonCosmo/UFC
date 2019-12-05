package com.cosmo.everton.main;

import java.util.List;

import com.cosmo.everton.structure.Heap;
import com.cosmo.everton.structure.Node;
import com.cosmo.everton.util.FileManager;
import com.cosmo.everton.util.StructureManager;

public class Main {

	public static void main(String[] args) {
		Heap heap;
		List<String> words;
		List <Node> nodes;
		List<String> patterns;
		
		
		patterns = FileManager.readFile("text.txt","patternsList");
		words = FileManager.readFile("text.txt", "wordsArray");
//		System.out.println(words);
		
//		nodes = StructureManager.createNodes(words);
		for(String word: words) { 
			for(String pattern : patterns) { 
			StructureManager.verifyRepeated(word,pattern);
			System.out.println("Word : "+word);
			System.out.println("Pattern: " +pattern);
			}
		}
//		heap = new Heap(nodes);
	}

}
