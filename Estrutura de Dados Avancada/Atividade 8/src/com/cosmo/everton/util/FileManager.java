package com.cosmo.everton.util;

import java.io.BufferedReader;
import java.io.FileReader;


import com.cosmo.everton.structure.Trie;

public abstract class FileManager {
	
	public static void  readFile(String filename,Trie trie){
		try { 
			long start = System.nanoTime();
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while((line =reader.readLine()) != null) { 
				trie.insert(line);
			}
			long elapsedTime = System.nanoTime()- start;
			System.out.println("FILE: "+filename+"\n" +" Total execution time in INSERT words : "+elapsedTime/1000000+" milliseconds\n");
			reader.close();
		}catch(Exception e) { 
			System.err.format("Exception reading file '%s' ",filename);
			e.printStackTrace();
		
		}
		
	}
	
}
	
