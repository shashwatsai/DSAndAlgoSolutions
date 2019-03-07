/*
	@author  Shashwat Tiwari
	@email   shashwat1791@gmail.com
*/

import java.util.*;
import java.lang.*;

/*
	Given an input string, generate the permutations in lexographically sorted order

	Input:

	ABC
    
    Output:

    ABC
    ACB
    BAC
    BCA
    CAB
    CBA

*/
public class PermutationLexo{


	public List<String> permute(char [] input){
		// create a map, of character with counts
		TreeMap<Character, Integer> map = new TreeMap<>();
		for(char ch : input){
			map.compute(ch, (key, val) -> {
				if(val == null){
					return 1;
				}else{
					return val+1;
				}
			});
		}

		char [] str   = new char[map.size()];
		int  [] count = new int[map.size()];

		int index = 0;
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}


		List<String> resultSet = new ArrayList<>();
		char [] result = new char[input.length];

		permuteUtil(str, count, result, 0, resultSet);
		return resultSet;
	} 

	public void permuteUtil(char [] str, int [] count, char [] result, int level, List<String> resultSet){
		// base case
		if(level == result.length){
			resultSet.add(new String(result));
			return;
		}

		for(int i=0 ; i < str.length; i++){
			if(count[i] == 0){
				continue;
			}

			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level + 1, resultSet);
			count[i]++;

		}

	}


	public static void main(String [] args){
		PermutationLexo test = new PermutationLexo();
		test.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
	}

}