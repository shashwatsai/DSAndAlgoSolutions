import java.util.*;

public class DiffPairs{

	static int pairs(int [] arr, int diff){
		Arrays.sort(arr);

		int i = 0, j = 1, totalPairs = 0;

		while( j < arr.length){
			int currDiff = arr[j] - arr[i];
			if(currDiff == diff){
				totalPairs++;
				j++;
				i++;
			}else if(currDiff < diff){
				j++;
			}else{
				i++;
			}
		}

		return totalPairs;

	}

	public static void main(String [] args){
		int [] arr = new int[]{1,3,4,2};
		int diff = 1;

		System.out.println(pairs(arr, diff));
	}
}