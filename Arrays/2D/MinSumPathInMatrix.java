public class MinSumPathInMatrix{

	private static int getMinSumPath(int [][] matrix){
		return getMinSumPathUtil(matrix, matrix.length-1, matrix[0].length-1);
	}

	private static int getMinSumPathUtil(int [][]matrix, int row, int col){
		
		int result = 0;
		// base cases
		if(row == 0 && col == 0){
			return matrix[row][col];
		}else if(row < 0 || col < 0){
			return Integer.MAX_VALUE;
		}else{
			result = matrix[row][col] + Math.min(getMinSumPathUtil(matrix, row-1, col), getMinSumPathUtil(matrix, row, col-1));
		}

		return result;
	}


	public static void main(String ...args){
		int [][] test = new int[][]{
			{1,3,2},
			{4,3,1},
			{5,6,1}
		};

		int res = getMinSumPath(test);
		System.out.println(res);
	}
}