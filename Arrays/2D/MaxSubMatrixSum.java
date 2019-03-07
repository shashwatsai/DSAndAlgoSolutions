import java.util.*;

class DesiredPositions{
	
	int maxSum, maxLeft, maxRight, maxUp, maxDown;
	Integer [] intermidiateArray;
	
	DesiredPositions(int rows){
		intermidiateArray = new Integer[rows];
		Arrays.fill(intermidiateArray, 0);
		this.maxSum = 0;
		this.maxLeft = 0;
		this.maxRight = 0;
		this.maxUp = 0;
		this.maxDown = 0;
	}

	public void setIntermidiateArray(Integer [] a){
		this.intermidiateArray = a;
	}
}

public class MaxSubMatrixSum{
	
	static int l=0, r=0;
	private static int getMaxSumSubMatrix(int [][] m){
		
		int currentSum = 0;
		int maxSum = 0;
		DesiredPositions d = new DesiredPositions(m.length);
		for(l=0; l < m[0].length; l++){
			for(r=l; r<m[0].length; r++){
				Integer [] currentColumn = Arrays.stream(m).map(o->o[r]).toArray(Integer[]::new);
				
				for(int i = 0; i<currentColumn.length; i++){
					currentColumn[i] += d.intermidiateArray[i];
				}

				d.maxLeft = l;
				d.maxRight = r;

				System.out.println(Arrays.toString(currentColumn));

				kadaneInterface(currentColumn, d);
				currentSum = d.maxSum;
				maxSum = Math.max(maxSum, currentSum);
			}

			d.setIntermidiateArray(new Integer[]{0,0,0,0});
		}

		return maxSum;
	}

	private static void kadaneInterface(Integer [] a, DesiredPositions d){
		int currentMaxSum = 0;
		int currentSum = 0;
		for(int i=0; i<a.length; i++){
			currentSum = Math.max(a[i], currentSum + a[i]);
			currentMaxSum = Math.max(currentMaxSum, currentSum);
		}
		
		d.setIntermidiateArray(a);

		d.maxSum = currentMaxSum;
	}




	public static void main(String [] args){
		int [][] input = new int [][] { 
                            {1, 2, -1, -4, -20}, 
                            {-8, -3, 4, 2, 1}, 
                            {3, 8, 10, 1, 3}, 
                            {-4, -1, 1, 7, -6} 
                            };

        int sum = getMaxSumSubMatrix(input);
        System.out.println(sum);
	}
}