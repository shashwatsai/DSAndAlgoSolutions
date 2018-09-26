/*
	@author Shashwat Tiwari
	@description Sub Rountine to find minimum window in which
				 the substring lies within a given text.

	@class MinWindowSubstring
*/

import java.util.*;

public class MinWindowSubstring{

	private static String findMinWindowSubstr(String text, String pat){
		// get the count of characters in pat to find
		HashMap<Character, Integer> target = new HashMap<>();
		for(int i=0; i<pat.length();i++){
			if(target.containsKey(pat.charAt(i))){
				target.put(pat.charAt(i), target.get(pat.charAt(i)+1));
			}else{
				target.put(pat.charAt(i), 1);
			}
		}

		int left      = 0;
		int minLeft   = 0;
		int minWindow = text.length()+1;
		int count     = 0;
		
		for(int right = 0; right < text.length(); right++){
			char c = text.charAt(right);
			if(target.containsKey(c)){
				target.put(c, target.get(c)-1);
				if(target.get(c) >= 0){
					count++;
				}

				// the window is present
				while(count == pat.length()){
					if(right-left+1 < minWindow){
						minLeft = left;
						minWindow = right-left+1;
					}

					if(target.containsKey(text.charAt(left))){
						target.put(text.charAt(left), target.get(text.charAt(left))+1);
						if(target.get(text.charAt(left)) > 0){
							count--;
						}
					}

					left++;
				}
			}
		}

		if(minWindow > text.length()){
			return "";
		}

		return text.substring(minLeft, minLeft+minWindow);

	}


	public static void main(String [] args){
		String text = "This is a String";
		String pat  = "isa";

		System.out.println(findMinWindowSubstr(text, pat));
	}
}