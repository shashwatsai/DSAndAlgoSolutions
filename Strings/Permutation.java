import java.util.*;

public class Permutation{

	private static void printPermutations(char [] arr){
		printUtil(arr, 0, arr.length-1);
	}

	private static void printUtil(char [] arr, int l, int r){
		if( l == r){
			System.out.println(Arrays.toString(arr));
		}

		for(int i = l; i <= r; i++){
			swap(arr, i, l);
			printUtil(arr, l+1, r);
			swap(arr, i, l);
		}
	}

	private static void swap(char [] arr, int l, int r){
		char temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp; 
	}

	public static void main(String [] args){
		String str = "ABC";
		printPermutations(str.toCharArray());
	}
}