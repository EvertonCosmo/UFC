package com.cosmo.everton.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.List;

public abstract class FileManager {

//	{typeReturn : splitWords, wordsArray}
	public static List<String> readFile(String filename,String typeReturn) {
		try { 
			ArrayList<String> arraySplit = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			String stringToSplit = null;
			while((line = reader.readLine()) != null) { 
					stringToSplit = line;
				
			}
		
			if(typeReturn.equals("patternsList")) { 
				String[] currencies = stringToSplit.split(" ");
				for (int i = 0; i < currencies.length; i++) {
					arraySplit.add(currencies[i]);
				}
				
			
				System.out.println("FILE: "+filename+"\n");
				reader.close();
				return arraySplit;
			}else if(typeReturn.equals("wordsArray")) { 
				
				arraySplit.add(StructureManager.RemoveRepeated(stringToSplit));
				return arraySplit;
			}
		
		}catch(Exception e) { 
			System.err.format("Exception reading file '%s' ",filename);
			e.printStackTrace();

		}
		return null;

	}
}
