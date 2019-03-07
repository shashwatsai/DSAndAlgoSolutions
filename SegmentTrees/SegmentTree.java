public class SegmentTree{

	private static int getNextOf2(int n){
		int count = 0;
		while( n != 0){
			n = n >> 1;
			count++;
		}
		return (int)Math.pow(count, 2);
	}

	private static int [] initializeSegmentTree(int [] arr){
		int n = getNextOf2(arr.length);
		int [] segmentTree = new int[2*n-1];


		constructSegmentTree(segmentTree, arr, 0, arr.length-1, 0);
		return segmentTree;
	}

	private static void constructSegmentTree(int [] segmentTree, int [] input, int start, int end, int pos){
		if(start == end){
			segmentTree[pos] = input[start];
			return;
		}

		int mid = (start + end)/2;

		// recurse to the left and the right
		constructSegmentTree(segmentTree, input, start, mid, 2*pos+1);
		constructSegmentTree(segmentTree, input, mid+1, end, 2*pos+2);

		segmentTree[pos] = Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
		return;
	}

	private static int rangeMinQuery(int [] segmentTree, int qStart, int qEnd, int start, int end, int pos){
		if(qStart <= start && qEnd >= end){
			return segmentTree[pos]; // complete overlap
		}

		if(qStart > end || qEnd < start){
			return Integer.MAX_VALUE; // non overlap
		}
		
		int mid = (start + end)/2;
		return Math.min(
			rangeMinQuery(segmentTree, qStart, qEnd, start, mid, 2*pos+1),
			rangeMinQuery(segmentTree, qStart, qEnd, mid+1, end, 2*pos+2)
		);
	}


	public static void main(String [] args){
		int [] arr = new int[]{1,3,5,2,6,7,23,12,9};
		int [] segmentTree = initializeSegmentTree(arr);
		System.out.println(rangeMinQuery(segmentTree, 6, 7, 0, arr.length-1, 0));
		
	}
}