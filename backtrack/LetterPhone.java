import java.util.*;
import java.util.stream.*;

public class LetterPhone{

    public static ArrayList<String> letterCombinations(String a) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "0");
        map.put(1, "1");
     
        ArrayList<String> result = new ArrayList<String>();
     
        if(a == null || a.length() == 0)
            return result;
     
        ArrayList<Character> temp = new ArrayList<Character>();
        backtrack(a, temp, result, map);
     
        return result;
    }

    private static void backtrack(String digits, List<Character> temp, List<String> result, Map<Integer, String> map){
    	if(digits.length() == 0){
    		String str = temp.stream().map(e->e.toString()).collect(Collectors.joining());
    		result.add(str);
    		return;
    	}

    	// get the current digit
    	Integer current = Integer.parseInt(digits.substring(0,1));
    	String letters = map.get(current);

    	for(int i = 0; i < letters.length(); i++){
    		temp.add(letters.charAt(i));
    		backtrack(digits.substring(1), temp, result, map);
    		temp.remove(temp.size()-1);
    	}

    }


	public static void main(String [] args){
		System.out.println(letterCombinations("23"));
	}
}