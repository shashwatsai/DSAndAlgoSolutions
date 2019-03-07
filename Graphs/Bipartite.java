import java.util.*;

class Graph{

	int vertices = 0;
	Map<Integer, List<Integer>> edges;

	Graph(int vertices){
		this.vertices = vertices;
		this.edges = new HashMap<>();
	}

	public void addEdge(int source, int destination, boolean isDirected){
		this.edges.computeIfAbsent(source, edges-> new ArrayList<Integer>()).add(destination);
		if(!isDirected){
			this.edges.computeIfAbsent(destination, edges-> new ArrayList<Integer>()).add(source);
		}
	}


	public boolean isBipartite(Graph g, int source){
		// consider 1 as first color and 0 as the second color
		int [] colors = new int[this.vertices];
		for(int i=0; i<vertices; i++){
			// indicate no vertex is being visited
			colors[i] = -1;
		}

		Queue<Integer> queue = new LinkedList<>();
		colors[source] = 1;

		queue.offer(source);

		while(!queue.isEmpty()){
			int currentVertex = queue.poll();
			int currentColor  = colors[currentVertex];

			// iterate through all the neighbours
			for(int nei : this.edges.get(currentVertex)){
				if(colors[nei] == -1){
					colors[nei] = 1-currentColor;
					queue.offer(nei);
				}else if(colors[nei] == currentColor){
					return false;
				}
				
			}
		}

		return true;
	}
}


public class Bipartite{

	public static void main(String [] args){
		Graph g = new Graph(4);
		g.addEdge(0,1, false);
		g.addEdge(1,2, false);
		g.addEdge(2,3, false);
		g.addEdge(3,0, false);

		boolean ans = g.isBipartite(g, 0);
		System.out.println(ans);
	}
}