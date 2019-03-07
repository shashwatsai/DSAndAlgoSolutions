import java.util.*;

public class LCS{

	private static Map<String, Integer> map= new HashMap<>();

	private static int findLCSLength(String a, String b, int la, int lb){
		if(la ==0 || lb == 0){
			return 0;
		}

		if(a.charAt(la-1) == b.charAt(lb-1)){
			return 1 + findLCSLength(a,b,la-1, lb-1);
		}
		
		return Math.max(findLCSLength(a,b,la-1,lb), findLCSLength(a,b,la,lb-1));
	}

	private static int findLCSLengthTopDownLookUp(String a, String b, int la, int lb, int [][] lookup){
		if(la == 0 || lb == 0){
			return 0;
		}

		if(lookup[la][lb] == 0){
			if(a.charAt(la-1) == b.charAt(lb-1)){
				lookup[la][lb] = findLCSLengthTopDownLookUp(a,b,la-1,lb-1, lookup) + 1;
			}else{
				lookup[la][lb] = Math.max(findLCSLengthTopDownLookUp(a,b,la-1,lb, lookup), findLCSLengthTopDownLookUp(a,b,la,lb-1, lookup));
			}
		}

		return lookup[la][lb];
	}

	private static int findLCSLengthTopDown(String a, String b, int la, int lb){
		String key = la+"|"+lb;
		if(map.containsKey(key))
			return map.get(key);

		if(la == 0 || lb == 0){
			map.put(key, 0);
			return 0;
		}

		if(a.charAt(la-1) == b.charAt(lb-1)){
			map.put(key, 1+ findLCSLengthTopDown(a, b, la-1, lb-1));
		}

		map.put(key,Math.max(findLCSLength(a,b,la-1,lb), findLCSLength(a,b,la,lb-1)));
		return map.get(key);

	}

	private static int findLCSLengthBottomUp(String a, String b){
		int n = a.length(), m = b.length();
		int [][] bottomup = new int[n+1][m+1];

		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					bottomup[i][j] = bottomup[i-1][j-1]+1;
				}else{
					bottomup[i][j] = Math.max(bottomup[i-1][j],bottomup[i][j-1]);
				}
			}
		}

		return bottomup[n][m];
	}

	public static void main(String [] args){
		String a = "ABCBDAB";
		String b = "BDCABA";
		int [][] lookup = new int[a.length()+1][b.length()+1];
		System.out.println(findLCSLengthTopDown(a, b, a.length(), b.length()));
		System.out.println(findLCSLengthBottomUp(a, b));
		System.out.println(findLCSLengthTopDownLookUp(a, b, a.length(), b.length(), lookup));
	}
}