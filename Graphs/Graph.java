import java.util.*;

public class Graph{

	private Map<Integer, ArrayList<Integer>> graph;

	Graph(){
		this.graph = new HashMap<>();
	}

	private void addEdge(int source, int destination, boolean directed){
		ArrayList<Integer> nodesFromSource = this.graph.get(source);
		if(nodesFromSource == null){
			nodesFromSource = new ArrayList<>();
			this.graph.put(source, nodesFromSource);
		}
		nodesFromSource.add(destination);

		// if it is not directed, make sure to add destination back to source in adjacency list
		if(!directed){
			ArrayList<Integer> nodesFromDestination = this.graph.get(destination);
			if(nodesFromDestination == null){
				nodesFromDestination = new ArrayList<>();
				this.graph.put(destination, nodesFromDestination);
			}
			nodesFromDestination.add(source);
		}
	}

	private void dfsUtil(int vertex, Map<Integer, Boolean> visited){
		// mark visited
		visited.computeIfAbsent(vertex, k-> true);
		System.out.print(vertex+"->");
		for(int nei : this.graph.get(vertex)){
			if(visited.get(nei) == null){
				dfsUtil(nei, visited);
			}
		}
	}

	public void dfs(int source){
		Map<Integer, Boolean> visited = new HashMap<>();
		this.dfsUtil(source, visited);
	}

	public static void main(String [] args){
		Graph g = new Graph();
		g.addEdge(0,1,false);
		g.addEdge(0,2,false);
		g.addEdge(1,2,false);
		g.addEdge(2,0,false);
		g.addEdge(2,2,false);
		g.addEdge(3,0,false);

		g.dfs(2);
		System.out.println();
	}
}