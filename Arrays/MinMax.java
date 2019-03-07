
public class MinMax{

	public static int[] returnMaxMin(int [] arr){
		int min = arr[0];
		int max = arr[0];


		for(int i=1; i<arr.length; i++){
			if(arr[i] < min)
				min = arr[i];

			if(arr[i] > max){
				max = arr[i];
			}
		}

		return new int[]{min, max};
	}

	public static void main(String [] args){
		int [] arr = new int[]{10,5,15,4,7,14,17};
		int [] res = returnMaxMin(arr);
 		System.out.println( res[0]+ " & " + res[1]);
	}
}