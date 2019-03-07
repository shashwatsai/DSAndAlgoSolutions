import java.util.*;

/*
	
	### [Challenge Name: Matrix](/challenges/matrix)


	The kingdom of Zion has cities connected by bidirectional roads.  There is a unique path between any pair of cities. Morpheus has found out that the machines are planning to destroy the whole kingdom.  If two machines can join forces, they will attack.  Neo has to destroy roads connecting cities with machines in order to stop them from joining forces.  There must not be any path connecting two machines.

	Each of the roads takes an amount of time to destroy, and only one can be worked on at a time.  Given a list of edges and times, determine the minimum time to stop the attack.

	For example, there are $n = 5$ cities called $0 - 4$.  Three of them have machines and are colored red.  The time to destroy is shown next to each road.  If we cut the two green roads, there are no paths between any two machines.  The time required is $3 + 2 = 5$.  

	![image](https://s3.amazonaws.com/hr-assets/0/1528209077-f7699103c6-matrixExample.png)  

	**Function Description**

	Complete the function *minTime* in the editor below.  It must return an integer representing the minimum time to cut off access between the machines.

	minTime has the following parameter(s):

	- *roads*: a two-dimensional array of integers, each $roads[i] = [city1, city2, time]$ where cities are connected by a road that takes $time$ to destroy  
	- *machines*: an array of integers representing cities with machines  

*/

class Subset{
	int parent;
	int rank;
	int machinesInSet;

	Subset(int parent){
		this.parent = parent;
		this.rank   = 0;
		this.machinesInSet = 0;
	}
}

public class KingdomOfZion{

	private static Subset [] subsets;

	private static void initialize(int n){
		subsets = new Subset[n];
		for(int i=0; i<n; i++){
			subsets[i] = new Subset(i);
		}
	}

	private static void union(int nodeA, int nodeB){
		int parentA = find(nodeA);
		int parentB = find(nodeB);

		if(parentA != parentB){
			if(subsets[parentA].rank < subsets[parentB].rank){
				subsets[parentA].parent = parentB;
				subsets[parentB].rank++;
				subsets[parentB].machinesInSet += subsets[parentA].machinesInSet;
			}else{
				subsets[parentB].parent = parentA;
				subsets[parentA].rank++;
				subsets[parentA].machinesInSet += subsets[parentB].machinesInSet;
			}
		}
	}

	private static boolean isSetWithMachine(int machine){
		int parentSet = find(machine);
		return subsets[parentSet].machinesInSet > 0;
	}

	private static int find(int nodeA){
		while(nodeA != subsets[nodeA].parent){
			nodeA = subsets[nodeA].parent;
		}

		return subsets[nodeA].parent;
	}

	static int minTime(int[][] roads, int[] machines) {

		// sort the roads in ascending order of energy needed to break
		Arrays.sort(roads, new Comparator<int[]>(){

			@Override
			public int compare(int [] arrA, int[] arrB){
				int componentA = arrA[2];
				int componentB = arrB[2];

				return componentB - componentA;
			}
		});

		for(int machine : machines){
			subsets[machine].machinesInSet++;
		}


		int minEnergy = 0;
		// start merging the cities as one connected component
		// and ignore a road which has a machine as one of the node
		for(int [] road: roads){
			int endpointA = road[0];
			int endpointB = road[1];
			int weight    = road[2];

			if(isSetWithMachine(endpointA) && isSetWithMachine(endpointB)){
				minEnergy += weight;
			}else{
				union(endpointA, endpointB);
			}

		}

		return minEnergy;
    }

	public static void main(String [] args){
		int n = 5;
		initialize(n);

		int [][] cities = new int[][]{
			{2,1,8},
			{1,0,5},
			{2,4,5},
			{1,3,4}
		};

		int [] machines = new int[]{0,2,4};

		System.out.println(minTime(cities, machines));
	}
}