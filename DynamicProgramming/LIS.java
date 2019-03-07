import java.util.*;

public class LIS{

	private static int lis(int [] a){
		int [] lis = new int[a.length];

		for(int i=0; i < a.length; i++){
			lis[i] = 1;
		}

		for(int i = 1; i < a.length; i++){
			for(int j = 0; j < i; j++){
				if(a[i] > a[j] && lis[i] < lis[j] + 1){
					lis[i] = lis[j] + 1;
				}
			}
		}

		return Arrays.stream(lis).max().getAsInt();
	}

	public static void main(String [] args){
		int [] arr = new int[]{10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis(arr));
	}
}