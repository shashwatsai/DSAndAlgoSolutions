import java.util.*;

class Ref{
	int i;
	String ans;

	Ref(){
		this.i = 0;
		this.ans = null;
	}
}

public class PermutationLexoNth{

	private static String permute(char [] arr, int n){
		TreeMap<Character, Integer> map = new TreeMap<>();

		for(char ch : arr){
			map.compute(ch, (k, v) -> {
				if(v == null)
					return 1;
				else 
					return v + 1;
			});
		}

		char [] str = new char[map.size()];
		int  [] count = new int[map.size()];

		int index = 0;

		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}

		int level = 0;
		char [] result = new char[arr.length];
		Ref r = new Ref();
		permuteUtil(str, count, level, result, r, n);
		return r.ans;
	}

	private static void permuteUtil(char [] str, int [] count, int level, char [] result,  Ref r, int n){
		// base case
		if(level == result.length){
			r.i++;
			if(r.i == n){
				r.ans = new String(result);
			}
		}

		for(int i = 0; i< str.length; i++){
			if(count[i] == 0)
				continue;

			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, level+1, result,r, n);
			count[i]++;
		}
	}


	public static void main(String [] args){
		System.out.println(permute("AABC".toCharArray(), 3));
	}
}