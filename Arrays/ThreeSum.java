/*

	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
	Return the sum of the three integers.

	Assume that there will only be one solution

*/

import java.util.*;

public class ThreeSum{

	public static int closestThreeSum(int [] arr, int target){
		// sort arrays in non decreasing order
		Arrays.sort(arr);

		int result = 0;

		int min = Integer.MAX_VALUE;
		for(int i= 0 ; i < arr.length - 2; i++){
			int l = i+1, r = arr.length-1;

			while( l < r){
				int s = arr[i] + arr[l] + arr[r];
				int diff = Math.abs(s - target);

				if(diff == 0){
					return s;
				}

				if( diff < min){
					min = diff;
					result = s;
				}

				if(s <= target){
					l++;
				}else{
					r--;
				}

			}
		}

		return result;

	}

	public static void main(String [] args){
		int [] arr = new int []{-1,2,1,4};
		System.out.println(closestThreeSum(arr, 1));
	}
}