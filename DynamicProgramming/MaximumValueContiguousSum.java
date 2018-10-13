/*
	@author Shashwat Tiwari
	@email  shashwat1791@gmail.com

	Problem Statement: Given an Input Array of Real Numbers A[1..n], find max(A[i]) i:0->n
*/
public class MaximumValueContiguousSum{

	private static int findMaxContiguousSum(int [] arr){
		int [] memo = new int[arr.length];
		memo[0] = arr[0];

		for(int i=1; i< arr.length; i++){
			memo[i] = Math.max(memo[i-1]+arr[i], arr[i]);
		}

		int max = memo[0];
		for(int i=0; i<memo.length;i++){
			if(memo[i] > max){
				max = memo[i];
			}
		}

		return max;
	}

	public static void main(String ...args){
		int [] arr = new int[]{3,-1,-1,4,6,-4,5};
		System.out.println(findMaxContiguousSum(arr));
	}
}