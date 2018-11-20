class Subset{
	int parent;
	int rank;

	Subset(int parent){
		this.parent = parent;
		this.rank   = 0;
	}
}

public class DisjointSetsPathCompression{

	private static Subset [] subsets;

	public static void initialize(int [] sets){
		subsets = new Subset[sets.length];
		for(int i=0; i<sets.length; i++){
			subsets[i] = new Subset(sets[i]);
		}
	}

	public static void union(int x, int y){
		int xRoot = find(x);
		int yRoot = find(y);

		if(subsets[xRoot].rank < subsets[yRoot].rank){
			subsets[xRoot].parent = yRoot;
		}else if(subsets[yRoot].rank < subsets[xRoot].rank){
			subsets[yRoot].parent = xRoot;
		}else{
			subsets[xRoot].parent = yRoot;
			subsets[yRoot].rank++;
		}
	}

	public static int find(int x){
		// if(subsets[x].parent != x){
		// 	subsets[x].parent = find(subsets[x].parent);
		// }
		while(subsets[x].parent != x){
			x = subsets[x].parent;
		}

		return x;
	}

	public static void main(String [] args){
		int [] sets = new int[]{0,1,2,3,4,5};
		initialize(sets);
		union(0,1);
		union(1,2);
		union(2,3);
		union(4,5);

		System.out.println(find(5));
	}
}