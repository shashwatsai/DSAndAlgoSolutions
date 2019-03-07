public class MajorityElement{

	private static int majorityElement(int [] arr){
		// error cases
		if(arr.length == 0 || arr.length == 1){
			return -1;
		}

		int candidate = findCandidateElement(arr);
		// check if the candidate is the majority element

		int count = 0;
		for(int n : arr){
			if( n == candidate)
				count++;
		}

		if(count > arr.length/2){
			return candidate;
		}else{
			return -1;
		}

	}

	private static int findCandidateElement(int [] arr){
		int candidate = arr[0];
		int count     = 1;

		for(int i=1;i<arr.length;i++){
			if(arr[i] == candidate){
				count++;
			}else{
				count--;
			}

			if(count < 0){
				candidate = arr[i];
				count = 1;
			}
		}

		return candidate;
	}


	public static void main(String [] args){
		int [] arr = new int[]{3, 3, 3, 2, 3, 3, 2, 4, 4};
		System.out.println(majorityElement(arr));
	}
}