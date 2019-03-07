import java.util.*;

public class BubbleSort{

	private static void bubbleSort(int [] arr){
		int n = arr.length;
		boolean swapped = false;
		for(int i = n-1; i>=0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}

			if(!swapped){
				// best case, O(n) when all the elements are already sorted.
				break;
			}
		}
	}


	public static void main(String [] args){
		int [] arr = new int[]{7,2,1,6,8,5,3,4};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}