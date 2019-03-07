import java.util.*;

public class RemoveDuplicatesInStr{

	private static String removeDuplicates(String str){
		TreeSet<Character> set = new TreeSet<>();

		char [] chArr = str.toCharArray();
		for(char ch : chArr){
			set.add(ch);
		}

		String strRes = "";
		for(char ch : set){
			strRes += ch;
		}

		return strRes;
	}

	public static void main(String [] args){
		String str = "geeksforgeeks";
		System.out.println(removeDuplicates(str));
	}
}