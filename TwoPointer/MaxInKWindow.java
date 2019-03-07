import java.util.*;

public class MaxInKWindow{

	private static ArrayList<Integer> getMaxInWindow(int [] arr, int k){
		ArrayList<Integer> result = new ArrayList<>();
		if(arr.length <= 1) return result;
		if(arr.length <= k) return new ArrayList<Integer>(){{add(Arrays.stream(arr).max().getAsInt());}};

		Deque<Integer> dq = new LinkedList<>();
		// handle first window
		for(int i = 0; i < k; i++){
			while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
				dq.pollLast();
			}
			dq.offerLast(i);			
		}

		for(int i = k; i<arr.length; i++){
			// add the maximum of the previous window
			result.add(arr[dq.peekFirst()]);

			// discard outliers carried from the prev window
			while(!dq.isEmpty() && dq.peekFirst() <= i-k){
				dq.pollFirst();
			}

			while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
				dq.pollLast();
			}

			dq.offerLast(i);

		}

		result.add(arr[dq.peekFirst()]);

		return result;
	}

	public static void main(String [] args){
		int [] arr = new int[]{1,3,2,3,4,2,6,5,4,1};

		//[3, 3, 4, 4, 6, 6, 6, 7]
		int k = 3;
		System.out.println(getMaxInWindow(arr, k));
	}
}