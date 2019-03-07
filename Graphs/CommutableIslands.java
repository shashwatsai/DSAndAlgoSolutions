import java.util.*;
/*

There are n islands and there are many bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

Example :
Input

         Number of islands ( n ) = 4
         1 2 1 
         2 3 4
         1 4 3
         4 3 2
         1 3 10
In this example, we have number of islands(n) = 4 . Each row then represents a bridge configuration. In each row first two numbers represent the islands number which are connected by this bridge and the third integer is the cost associated with this bridge.

In the above example, we can select bridges 1(connecting islands 1 and 2 with cost 1), 3(connecting islands 1 and 4 with cost 3), 4(connecting islands 4 and 3 with cost 2). Thus we will have all islands connected with the minimum possible cost(1+3+2 = 6). 
In any other case, cost incurred will be more.

*/
class Subset{

	int parent;
	int rank;
	int size;

	Subset(int parent){
		this.parent = parent;
		this.rank   = 0;
		this.size   = 1;
	}
}

public class CommutableIslands{

	static Subset[] subsets;

	static void initialize(int verticies){
		subsets = new Subset[verticies+1];
		subsets[0] = new Subset(0);

		for(int i = 0; i < verticies; i++){
			subsets[i+1] = new Subset(i+1);
		}
	}

	static int find(int vertex){
		while(subsets[vertex].parent != vertex){
			vertex = subsets[vertex].parent;
		}

		return subsets[vertex].parent;
	}

	static void union(int a, int b){
		int parentA = find(a);
		int parentB = find(b);

		if(parentA != parentB){
			if(subsets[parentA].rank < subsets[parentB].rank){
				subsets[parentA].parent = parentB;
				subsets[parentB].rank++;
				subsets[parentB].size += subsets[parentA].size;
			}else{
				subsets[parentB].parent = parentA;
				subsets[parentA].rank++;
				subsets[parentA].size += subsets[parentB].size;
			}
		}
	}

	static int minCost(int [][] bridges, int verticies){
		initialize(verticies);
		// sort the arrays based on the cost
		Arrays.sort(bridges, new Comparator<int []>(){
			@Override
			public int compare(int [] a, int [] b){
				return a[2]-b[2];
			}
		});

		int minCost = 0;

		//System.out.println(Arrays.deepToString(bridges));
		for(int [] bridge: bridges){
			int nodeA = bridge[0];
			int nodeB = bridge[1];
			int cost  = bridge[2];

			if(find(nodeA) != find(nodeB)){
				union(nodeA, nodeB);
				minCost += cost;
			}
		}

		return minCost;
	}

	public static void main(String [] args){

		int n = 4;
		int [][]bridges = new int[][]{
			{1,2,1},
			{2,3,4},
			{1,4,3},
			{4,3,2},
			{1,3,10}
		};


		System.out.println(minCost(bridges, n));

	}
}