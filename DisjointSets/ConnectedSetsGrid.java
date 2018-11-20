/*

### [Challenge Name: DFS: Connected Cell in a Grid](/challenges/ctci-connected-cell-in-a-grid)


Consider a matrix where each cell contains either a $0$ or a $1$ and any cell containing a $1$ is called a *filled* cell. Two cells are said to be *connected* if they are adjacent to each other horizontally, vertically, or diagonally.  In the diagram below, the two colored regions show cells connected to the filled cells.  Black on white are not connected.

Cells adjacent to filled cells:  ![image](https://s3.amazonaws.com/hr-assets/0/1528204809-ea89cbdef6-connected.png)  

If one or more filled cells are also connected, they form a *region*. Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.

Regions:  ![image](https://s3.amazonaws.com/hr-assets/0/1528205314-6fa4d1c8c7-connected2.png)  

Given an $n \times m$ matrix, find and print the number of cells in the largest *region* in the matrix.  

**Function Description**

Complete the function *maxRegion* in the editor below.  It must return an integer value, the size of the largest region.

maxRegion has the following parameter(s):  

- *grid*: a two dimensional array of integers

*/

class ConnectedComponentSize{
	int size;
}

public class ConnectedSetsGrid{

	private static void markUnVisited(boolean [][] visited){
		for(int i=0; i< visited.length; i++){
			for(int j=0; j< visited[0].length; j++){
				visited[i][j] = false;
			}
		}
	}

	private static int maxRegion(int [][] grid){
		boolean [][] visited = new boolean[grid.length][grid[0].length];
		// mark all nodes as unvisited
		markUnVisited(visited);
		int totalRows = visited.length;
		int totalCols = visited[0].length;

		int maxSize = -1;
		ConnectedComponentSize sizeRef = new ConnectedComponentSize();
		for(int i=0; i< visited.length; i++){
			for(int j=0; j< visited[0].length; j++){
				// no need to check whether cells are in defined ranges here
				if(visited[i][j] == false && grid[i][j]==1){
					dfsUtil(grid, visited, i, j, totalRows, totalCols, sizeRef);
					maxSize = Math.max(maxSize, sizeRef.size);
					sizeRef.size = 0;
				}
			}
		}

		return maxSize;

	}

	private static void dfsUtil(int [][] grid, boolean [][] visited, int row, int col, int totalRows, int totalCols, ConnectedComponentSize c){
		// mark the cell as visited
		visited[row][col] = true;
		c.size++;

		// check all the possible adjacent cells
		if(isSafe(row-1, col-1, totalRows, totalCols)){
			if(visited[row-1][col-1]==false && grid[row-1][col-1]==1){
				dfsUtil(grid, visited, row-1, col-1, totalRows, totalCols, c);
			}
		}
		if(isSafe(row-1, col, totalRows, totalCols)){
			if(visited[row-1][col]==false && grid[row-1][col]==1){
				dfsUtil(grid, visited, row-1, col, totalRows, totalCols, c);
			}
		}
		if(isSafe(row-1, col+1, totalRows, totalCols)){
			if(visited[row-1][col+1]==false && grid[row-1][col+1]==1){
				dfsUtil(grid, visited, row-1, col+1, totalRows, totalCols, c);
			}
		}
		if(isSafe(row, col-1, totalRows, totalCols)){
			if(visited[row][col-1]==false && grid[row][col-1]==1){
				dfsUtil(grid, visited, row, col-1, totalRows, totalCols, c);
			}
		}
		if(isSafe(row, col+1, totalRows, totalCols)){
			if(visited[row][col+1]==false && grid[row][col+1]==1){
				dfsUtil(grid, visited, row, col+1, totalRows, totalCols, c);
			}
		}
		if(isSafe(row+1, col-1, totalRows, totalCols)){
			if(visited[row+1][col-1]==false && grid[row+1][col-1]==1){
				dfsUtil(grid, visited, row+1, col-1, totalRows, totalCols, c);
			}
		}
		if(isSafe(row+1, col, totalRows, totalCols)){
			if(visited[row+1][col]==false && grid[row+1][col]==1){
				dfsUtil(grid, visited, row+1, col, totalRows, totalCols, c);
			}
		}
		if(isSafe(row+1, col+1, totalRows, totalCols)){
			if(visited[row+1][col+1]==false && grid[row+1][col+1]==1){
				dfsUtil(grid, visited, row+1, col+1, totalRows, totalCols, c);
			}
		}
	}

	private static boolean isSafe(int row, int col, int totalRows, int totalCols){
		// check for valid rows and columns
		if(row >= 0 && row < totalRows){
			if(col >= 0 && col < totalCols){
				return true;
			}
		}

		return false;
	}


	public static void main(String [] args){
		int [][] grid = new int[][]{
			{1,1,0,0},
			{0,1,1,0},
			{0,0,1,0},
			{1,0,0,0}
		};

		System.out.println(maxRegion(grid));

	}
}