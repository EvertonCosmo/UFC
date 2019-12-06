package com.cosmo.everton.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import com.cosmo.everton.structure.Node;

public abstract class StructureManager {


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
	public static Node  verifyRepeated(String word,String pattern) { 
		int i,j,k,occurrences = 0;
		int d[] = new int[257] ;
		for(j=0;j<=256;j++)
			d[j] = pattern.length();//tamanho do padrao
		for(j=1;j<pattern.length();j++)
			d[word.charAt(j-1)] = pattern.length()-j;//até o penultimo
		i=pattern.length();
		while(i<=word.length()){
			k=i;
			j=pattern.length();
			char c= word.charAt(k-1);
			char p = pattern.charAt(j-1);
			
			while(c == p && j>0){
				
				k--;
				j--;
				if(j>0) { 
					c= word.charAt(k-1);
					p=  pattern.charAt(j-1);
				}
			}
			if(j==0) { 
	
				System.out.print(word);
				System.out.printf(" index : %d",k+1); // index
				System.out.println("| "+pattern);
				occurrences++;
				
			}
			i = i + d[word.charAt(i-1)];
		}
		 Node node = new Node(occurrences, pattern);
		 
		 return node;
		
	}
	// BMH
	//		public static void  verifyRepeated(String word,String pattern) { 
	//			int i = pattern.length()-1; 
	//			int j = pattern.length()-1;
	//		
	//			do { 
	//		
	//				if(pattern.charAt(j) == word.charAt(i)) { 
	//					if(j == 0) { 
	//						System.out.println(word + " |" + pattern);
	//						System.out.println(i);
	//						return ;
	//						
	//					}else { 
	//						i--;
	//						j--;
	//					}	
	//				}else {
	//					i = i + pattern.length() - min(j, 1+last(word.charAt(i),pattern));
	//					
	//					j = pattern.length()-1;
	//				}
	//			}while(i <= word.length()-1);
	//			System.out.println("c");
	//			
	//		}
	//		
	//		
	//		  public static int last(char c, String P)
	//		    {
	//			 
	//		        for (int i=P.length()-1; i>=0; i--)
	//		        {
	//		            if (P.charAt(i) == c)
	//		            {
	//		                return i;
	//		            }
	//		        }
	//		        return -1;
	//		}
	//		public static int min(int a, int b) { 
	//			 if (a < b)
	//		            return a;
	//		        else if (b < a)
	//		            return b;
	//		        else 
	//		return a;
	//		}
} 