package com.cosmo.everton.structure;

import java.util.LinkedList;
import java.util.Map;

public class Trie {
		private TrieNode root;
		
		public Trie(){ 
			root = new TrieNode(); 
		}
	
		public TrieNode getRoot() {
			return root;
		}

		public boolean insert(String word) { 
			TrieNode head = root;
			
			for(char ch : word.toCharArray()) {
				if(head.getChild(ch) == null) { 
					head.setChild(ch);
				}
				head =head.getChild(ch);
			
			}
			if(head.isEndOfWord()) { 
	
				return false;
			}
			
			head.setEndOfWord(true);
			
			return true;
		}
		
//		public void insert(String word) { 
//			TrieNode currentRoot = root;
//			
//			for(int i=0; i<word.length(); i++) { 
//				currentRoot = currentRoot.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode()); // if charAt(i) null, create a new TrieNode
//			
//			}
//			currentRoot.setEndOfWord(true);
//		}
		public boolean search(String word) { 
			if(word.isEmpty()) {
				return false;
			}
			System.out.println("Searching ... " + word);
			TrieNode head = root;
			for(char ch : word.toCharArray()) { 
				head = head.getChild(ch);
				
				if(head == null) { 
					return false;
				}
			}
			return head.isEndOfWord();

		}

		 
		public void show(TrieNode t) { 
			long start = System.nanoTime();
			if(t ==null || t.isEndOfWord()) { 
				return;
			}
			LinkedList<TrieNode> list = new LinkedList<TrieNode>();
			System.out.println(t);
			t.setEndOfWord(true);
			
			list.add(t);
			
			while(!list.isEmpty()) { 
				TrieNode x = list.removeFirst();
				for(Map.Entry<Character, TrieNode> i: x.getChildren().entrySet()) { 
					if(i.getValue().isEndOfWord() == false) { 
						System.out.println(i);
						i.getValue().setEndOfWord(true);
						list.add(i.getValue());
					}
				}
			}
			long elapsedTime = System.nanoTime()- start;
			System.out.println("Total execution time in SHOW TRIE words : "+elapsedTime/1000000+" milliseconds");

		
			
		}
		
}


