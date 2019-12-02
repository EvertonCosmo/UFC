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
		words = FileManager.readFile("text.txt");
		nodes = StructureManager.createNodes(words);
		StructureManager.verifyRepeated(words);
		heap = new Heap(nodes);
	}

}
