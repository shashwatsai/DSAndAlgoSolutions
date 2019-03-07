/*

There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.

Input Format

1st argument given is an Integer x.
2nd argument given is an Integer y.
3rd argument given is an Integer N, number of circles.
4th argument given is an Integer R, radius of each circle.
5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
Output Format

Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
Constraints

0 <= x, y, R <= 100
1 <= N <= 1000
Center of each circle would lie within the grid
For Example

Input:
    x = 2
    y = 3
    N = 1
    R = 1
    A = [2]
    B = [3]
Output:
    NO
   
Explanation:
    There is NO valid path in this case

*/

import java.util.*;  

class Point{
	int x, y;

	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}  

public class ValidPath{

	public static boolean getValidPath(int x /*target row*/, int y /*target columns*/, 
		int N/*number of circles*/, 
		int R/*Radius of each circle*/, 
		List<Integer> A/* X cooridinate of ith circle*/, List<Integer> B /* Y Coordinate of ith circle*/){


		// mark all the nodes as unvisited
		int [][] cells = new int[x+1][y+1];
		for(int [] row : cells){
			Arrays.fill(row, 0);
		}

		// mark all the cells as blocked if a circle covers them
		for(int i = 0; i <= x; i++){
			for(int j=0; j<= y; j++){
				for(int k = 0; k < N; k++){
					/* get the euclidian distance */
					if(Math.sqrt(Math.pow(A.get(k)-i,2) + Math.pow(B.get(k)-j,2)) <= R){
						// mark cell as blocked
						cells[i][j] = -1;
					}
				}
			}
		}

		if(cells[0][0] == -1)
			return false;

		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0));

		while(!q.isEmpty()){
			Point current = q.poll();
			int currX = current.x;
			int currY = current.y;

			// mark the cell as visited
			cells[currX][currY] = 1;

			// add all the eight possibilities to queue if valid
			// top
			if(currX > 0 && cells[currX-1][currY] != -1 && cells[currX-1][currY] != 1){
				q.offer(new Point(currX-1, currY));
			}

			// down
			if(currX < x && cells[currX+1][currY] != -1 && cells[currX+1][currY] != 1){
				q.offer(new Point(currX+1, currY));
			}

			// left
			if(currY > 0 && cells[currX][currY-1] != -1 && cells[currX][currY-1] != 1){
				q.offer(new Point(currX, currY-1));
			}

			// right
			if(currY < y && cells[currX][currY+1] != -1 && cells[currX][currY+1] != 1){
				q.offer(new Point(currX, currY+1));
			}

			// top left
			if(currX > 0 && currY > 0 && cells[currX-1][currY-1] != -1 && cells[currX-1][currY-1] != 1){
				q.offer(new Point(currX-1, currY-1));
			}

			// top right
			if(currX > 0 && currY < y && cells[currX-1][currY+1] != -1 && cells[currX-1][currY+1] != 1){
				q.offer(new Point(currX-1, currY+1));
			}

			// bottom left
			if(currX < x && currY > 0 && cells[currX+1][currY-1] != -1 && cells[currX+1][currY-1] != 1){
				q.offer(new Point(currX+1, currY-1));
			}

			// bottom right
			if(currX < x && currY < y && cells[currX+1][currY+1] != -1 && cells[currX+1][currY+1] != 1){
				q.offer(new Point(currX+1, currY+1));
			}
		}

		return cells[x][y] == 1 ? true : false;
	}


	public static void main(String [] args){
		/*
			x = 2
		    y = 3
		    N = 1
		    R = 1
		    A = [2]
		    B = [3]

		*/
		List<Integer> A = new ArrayList<>();
		List<Integer> B = new ArrayList<>();
		A.add(2);B.add(3);
		System.out.println(getValidPath(2,3,1,1,A,B));

	}
}