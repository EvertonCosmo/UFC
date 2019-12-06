package com.cosmo.everton.main;

import java.util.ArrayList;
import java.util.List;

import com.cosmo.everton.structure.Heap;
import com.cosmo.everton.structure.Node;
import com.cosmo.everton.util.FileManager;
import com.cosmo.everton.util.StructureManager;

public class Main {

	public static void main(String[] args) {
		Heap heap;
		List<String> words;
		List <Node> nodes = new ArrayList<Node>();
		List<String> patterns;
		
		
		patterns = FileManager.readFile("text.txt","patternsList");
		words = FileManager.readFile("text.txt", "wordsArray");
		System.out.println("Texto: "+words);
		System.out.println("Padrão: "+patterns);

		for(String word: words) { 
			for(String pattern : patterns) { 
			nodes.add(StructureManager.verifyRepeated(word, pattern));
			}
		}
		System.out.println();
		heap = new Heap(nodes);
		System.out.println(heap.toString());
	}

}
