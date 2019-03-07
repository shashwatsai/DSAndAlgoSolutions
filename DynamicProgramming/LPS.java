public class LPS{

	private static int getLPSLengthRec(String str, int l, int r){
		if(l == r){
			return 1;
		}

		if(l > r){
			return 0;
		}

		if(l+1 == r){
			if(str.charAt(l) != str.charAt(r))
				return 0;
			else
				return 2;
		}
		
		
		if(str.charAt(l) == str.charAt(r))
			return getLPSLengthRec(str, l+1, r-1)+2;
		return Math.max(getLPSLengthRec(str, l+1, r), getLPSLengthRec(str, l, r-1));
	}

	public static void main(String [] args){
		String str = "GEEKSFORGEEKS";
		System.out.println(getLPSLengthRec(str, 0, str.length()-1));
	}
}