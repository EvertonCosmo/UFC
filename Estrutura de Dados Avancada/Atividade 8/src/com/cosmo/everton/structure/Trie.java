package com.cosmo.everton.structure;



public class Trie {
		private TrieNode root;
		
		public Trie(){ 
			root = new TrieNode(); 
		}
	
		public TrieNode getRoot() {
			return root;
		}

		public void insert(String word) { 
			TrieNode currentRoot = root;
			
			for(int i=0; i<word.length(); i++) { 
				currentRoot = currentRoot.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode()); // if charAt(i) null, create a new TrieNode
				currentRoot.setContent(word);
			}
			currentRoot.setEndOfWord(true);
		}
		public boolean search(String word) { 
			TrieNode currentRoot = root;
			for(int i=0; i< word.length(); i++) { 
				char index = word.charAt(i);
				TrieNode node = currentRoot.getChildren().get(index);
				if(node == null) { 
					return false;
				}
				currentRoot = node;
			}
			
			return (currentRoot != null && currentRoot.isEndOfWord());
		}
		 private boolean isEmpty() { 
			return root.getChildren().isEmpty();
		}
		public void show() { 
			System.out.println(root.getChildren());
			if(this.isEmpty()) {
				System.out.println("trie vazia");
				return ;
			}
			root.getChildren().values().stream().forEach(System.out::println);
			
			

			
			
		}
		
}


