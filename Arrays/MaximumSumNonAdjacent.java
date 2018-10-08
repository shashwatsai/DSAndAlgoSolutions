public class MaximumSumNonAdjacent{


	public static void main(String ...args){	
		int [] arr = new int[]{5,1,6,2};
		int [] dp = new int[arr.length + 1];

		dp[0] = 0;
		dp[1] = arr[0];

		for(int i=2; i< dp.length; i++){
			dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i-1]);
		}

		System.out.println(dp[dp.length-1]);
	}
}