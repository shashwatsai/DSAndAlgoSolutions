import java.util.*;

/*

### [Challenge Name: Merging Communities ](/challenges/merging-communities)


People connect with each other in a social network. A connection between Person $I$ and Person $J$ is represented as $\text{M I J}$. When two persons belonging to different communities connect, the net effect is the merger of both communities which $I$ and $J$ belongs to. 

At the beginning, there are $N$ people representing $N$ communities. Suppose person $1$ and $2$ connected and later $2$ and $3$ connected, then $1$,$2$, and $3$ will belong to the same community.

There are two type of queries:

1. $\text{M I J} \implies$ communities containing person $I$ and $J$ merged (if they belong to different communities).

2. $\text{Q I} \implies$ print the size of the community to which person $I$ belongs. 

*/


class Subset{

	int parent;
	int size;

	Subset(int parent){
		this.parent = parent;
		this.size = 1;
	}

	@Override
	public String toString(){
		return "Parent : " + this.parent + ", size: " + this.size;
	}
}

public class MergingCommunities{

	private static Subset [] subsets;

	private static void initialize(int numberOfPeople){
		subsets = new Subset[numberOfPeople+1];
		subsets[0] = new Subset(0);
		for(int i=0; i< numberOfPeople; i++){
			subsets[i+1] = new Subset(i+1);
		}
	}

	private static int find(int person){
		while (person != subsets[person].parent){
			person = subsets[person].parent;
		} 

		return subsets[person].parent;
	}

	private static void union(int personA, int personB){
		int parentA = find(personA);
		int parentB = find(personB);

		if(parentA != parentB){
			if(subsets[parentA].size < subsets[parentB].size){
				subsets[parentA].parent = parentB;
				subsets[parentB].size += subsets[parentA].size;
			}else {
				subsets[parentB].parent = parentA;
				subsets[parentA].size += subsets[parentB].size;
			}			
		}

	}

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int numberOfPeople = sc.nextInt();
		int numberOfQueries = sc.nextInt();

		initialize(numberOfPeople);

		for(int i=0; i <= numberOfQueries; i++){
			String query = sc.nextLine();
			if(!query.isEmpty()){
				String queryType = query.split(" ")[0];
				int personA = 0, personB = 0;
				if(queryType.equalsIgnoreCase("q")){
					personA = Integer.parseInt(query.split(" ")[1]);
					System.out.println(subsets[find(personA)].size);	
				}else{
					personA = Integer.parseInt(query.split(" ")[1]);
					personB = Integer.parseInt(query.split(" ")[2]);	
					union(personA, personB);
				}
			}

		}
	}
}