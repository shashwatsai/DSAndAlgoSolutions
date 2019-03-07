/*
	
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	Find all unique triplets in the array which gives the sum of zero.

	Note:

 	Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
	The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
	(-1, 0, 1)
	(-1, -1, 2) 

*/
import java.util.*;

public class ThreeSumZero{

	public static ArrayList<ArrayList<Integer>> threeSum(int [] arr){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		// sor the arrat in non decreasing order
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-2; i++){
				
			if(i > 0 && arr[i] == arr[i-1]){
				continue;
			}

			int a = arr[i];
			int j = i+1, k = arr.length - 1;
			while( j < k) {
				int b = arr[j], c = arr[k];
				int s = a + b + c;

				if(s > 0){
					k--;
				}else if( s < 0){
					j++;
				}else{
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(a);
					temp.add(b);
					temp.add(c);
					res.add(temp);

					while(j < k && arr[j] == arr[j+1]){
						j++;
					}

					while(j < k && arr[k] == arr[k-1]){
						k--;
					}

					j++;
					k++;
				}
			}
		}


		return res;

	}


	public static void main(String [] args){
		int [] arr = new int[]{-2, 5, 3, 0, 0, 5, 2, -1, 1,-4, 0, -4, 2};
		System.out.println(threeSum(arr));

	}
}