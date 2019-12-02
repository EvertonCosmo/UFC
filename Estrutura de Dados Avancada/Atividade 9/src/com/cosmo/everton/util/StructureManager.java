package com.cosmo.everton.util;

import java.util.ArrayList;
import java.util.List;

import com.cosmo.everton.structure.Node;

public abstract class StructureManager {

	// Receive words to create each node to HEAP 
	// count 0 to all
	public static List<Node> createNodes (List<String> words) {
		List <Node> nodes = new ArrayList<Node>();
		
		for(String word : words) { 		
			nodes.add(new Node(0, word));
		}
		System.out.println(nodes.toString());

		return nodes;

	}
	public static void verifyRepeated(List<String> words) { 
		for(String word: words) { 
			
		}
	}
}
