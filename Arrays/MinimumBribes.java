public class MinimumBribes{

	private static void minimumBribes(int [] q){
		int bribes = 0;
		boolean valid = false;
		for(int i = 0; i < q.length; i++){
			// check the difference of value at current position and index
			int current_index = i+1;
			int current_person = q[i];

			int diff = current_person - current_index;
			if(diff <= 2 && diff > 0){
				bribes += diff;
				valid = true;
			}else if(diff > 2){
				valid = false;
			}
		}

		if(valid){
			System.out.println(bribes);
		}else{
			System.out.println("Too Chaotic");
		}
		
	}

	public static void main(String [] args){
		int [] bribes = new int[]{2,5,1,3,4};
		minimumBribes(bribes);
	}
}