package com.cosmo.everton.util;

import java.text.Normalizer;
import java.util.regex.Pattern;


public abstract class Normalize {

	
	public static String normalize(String str) { 
      String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	  return pattern.matcher(nfdNormalizedString).replaceAll("");
			
			  
	}
}
