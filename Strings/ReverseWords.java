import java.util.*;

public class ReverseWords{

	private static String reverseWords(String str){
		String [] words  = str.split(" ");
		Arrays.stream(words).map(String::trim).toArray(unused -> words);

		String ans = "";
		for(int i = words.length-1; i >= 0; i--){
			ans += words[i] + " ";
		}

		return ans;
	}

	public static void main(String [] args){
		String str = "I love programming very much";
		String ans = reverseWords(str);
		System.out.println(ans);
	}
}