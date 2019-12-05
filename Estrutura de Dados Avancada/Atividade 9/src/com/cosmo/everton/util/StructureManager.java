package com.cosmo.everton.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import com.cosmo.everton.structure.Node;

public abstract class StructureManager {

	// Receive words to create each node to HEAP 
	// count 0 to all
//	public static List<Node> createNodes (List<String> words) {
//		List <Node> nodes = new ArrayList<Node>();
//
//			
//		for(String word : words) { 	
//			verifyRepeated(words.get(words.size()-1),word );
//			nodes.add(new Node(0, word));
//		}
//		System.out.println(nodes.toString());
//
//		return nodes;
//
//	}
	public static String RemoveRepeated(String str) { 
		  String[] strWords = str.split("\\s+");
	        
	        //convert String array to LinkedHashSet to remove duplicates
	        LinkedHashSet<String> lhSetWords 
	            = new LinkedHashSet<String>( Arrays.asList(strWords) );
	        
	        //join the words again by space
	        StringBuilder sbTemp = new StringBuilder();
	        int index = 0;
	        
	        for(String s : lhSetWords){
	            
	            if(index > 0)
	                sbTemp.append(" ");
	        
	            sbTemp.append(s);
	            index++;
	        }
	        
	        str = sbTemp.toString();
	        return str;
		
	}
	// BMH
	public static void verifyRepeated(String word,String pattern) { 
		int i = pattern.length()-1; 
		int j = pattern.length()-1;
		
		do { 
			System.out.println(word.length());
			if(pattern.charAt(j) == word.charAt(i)) { 
				if(j == 0) { 
					System.out.println("Match !");
//					System.out.println(pattern.charAt(j));
//					System.out.println(word.charAt(i));
				}else { 
					i--;
					j--;
				}	
			}else {
				System.out.println("Não deu match");
				i = i + pattern.length() - min(j, 1+last(word.charAt(i),pattern));
				j = pattern.length()-1;
			}
		}while(i <= word.length()-1);
	}
	
	
	  public static int last(char c, String P)
	    {
	        for (int i=P.length()-1; i>=0; i--)
	        {
	            if (P.charAt(i) == c)
	            {
	                return i;
	            }
	        }
	        return -1;
	}
	public static int min(int a, int b) { 
		 if (a < b)
	            return a;
	        else if (b < a)
	            return b;
	        else 
	return a;
	}
} 