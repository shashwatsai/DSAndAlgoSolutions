import java.util.*;

public class CheckPangram{


    public static boolean checkPangram(String str) 
    { 
        boolean[] mark = new boolean[26]; 

        int index = 0; 

        for (int i = 0; i < str.length(); i++) 
        { 

			if('a' <= str.charAt(i) && str.charAt(i) <= 'z') 
				index = str.charAt(i) - 'a'; 
            mark[index] = true; 
        } 

        for (int i = 0; i <= 25; i++) 
            if (mark[i] == false) 
                return (false); 
  
        return (true); 
    } 

    public static String isPangram(List<String> sentences){
    	StringBuilder result = new StringBuilder("");
    	for(String str : sentences){
    		if(checkPangram(str)){
    			result.append("1");
    		}else{
    			result.append("0");
    		}
    	}

    	return result.toString();
    }


	public static void main(String [] args){
		List<String> input = new ArrayList<>();

		input.add("we promptly judged antique ivory buckles for the next prize");
		input.add("we promptly judged antique ivory buckles for the prizes");
		input.add("the quick brown fox jumps over the lazy dog");
		input.add("the quick brown fox jump over the lazy dog");

		System.out.println(isPangram(input));



	}
}