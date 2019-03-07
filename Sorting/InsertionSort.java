import java.util.*;

public class InsertionSort{

	private static void insertionSort(int [] arr){

		for(int i = 1; i < arr.length; i++){
				
			int hole = i;
			int key  = arr[i];

			while(hole > 0 && arr[hole-1] > key){
				arr[hole] = arr[hole-1];
				hole--;
			}

			arr[hole] = key;
		}
	}

	public static void main(String [] args){
		int [] arr = new int[]{7,2,1,6,8,5,3,4};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}