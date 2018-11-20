import java.util.*;

public class CheckEvenLengthMax{

	public static String getDesiredWord(String sentence){
		int maxLength = -1;
		HashMap<Integer, String> wordMap = new HashMap<>();
		
		String [] words = sentence.split(" ");
		Arrays.stream(words).map(String::trim).toArray(unused -> words);

		for(String word : words){
			// get the length of the word
			int currLength = word.length();
			if(!isEven(currLength)){
				continue;
			}else{
				if(currLength > maxLength){
					maxLength = currLength;
					wordMap.put(maxLength, word);
				}
			}

		}

		return wordMap.get(maxLength);
	}

	private static boolean isEven(int n){
		return n%2 == 0;
	}

	public static void main(String [] args){
		String str = "it is a pleasent day today";
		System.out.println(getDesiredWord(str));
	}
}