public class PartitionIntoSets{

	private static int getMinDiffBetweenSets(int [] arr, int index, int sumCurrent, int sumTotal){

		// base case
		if(index == 0){
			return Math.abs((sumTotal-sumCurrent) - sumCurrent);
		}

		return Math.min(getMinDiffBetweenSets(arr,index-1, sumCurrent+arr[index],sumTotal), getMinDiffBetweenSets(arr, index-1, sumCurrent,sumTotal));
	}

	public static void main(String [] args){
		int [] arr = new int[]{1, 6, 11, 5};
		System.out.println(getMinDiffBetweenSets(arr,arr.length-1,0,23));
	}
}