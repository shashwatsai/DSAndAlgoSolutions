/*
	
	Quicksort:

	<ul>
		<li>Quicksort is a In-place sorting algorithm</li>
		<li>On an average case it is O(nlogn)</li>
		<li>Worst case, it has O(n2), but using randomized pivot, it is easier to get O(nlogn)</li>
		<li>Used in most of the efficient algorithms</li>
	</ul>
	
*/

import java.util.*;

public class Quicksort{

	private static int getPivotIndex(int [] arr, int start, int end){
		int pivot = arr[end];
		int pIndex = 0;

		for(int i=0; i<end; i++){
			if(arr[i] < pivot){
				swap(arr, i, pIndex);
				pIndex++;
			}
		}

		swap(arr, pIndex, end);
		return pIndex;
	}

	private static void swap(int [] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private static void quickSort(int [] arr, int start, int end){
		if(start < end){
			int pIndex = getPivotIndex(arr, start, end);
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}

	public static void main(String [] args){
		int [] arr = new int[]{7,2,1,6,8,5,3,4};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}