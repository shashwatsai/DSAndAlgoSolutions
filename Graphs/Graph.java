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

	private boolean hasCycle(){
		// get all the verticies of graph
		Set<Integer> verticies = this.graph.keySet();
		
		Map<Integer, Boolean> visited = new HashMap<>();
		Map<Integer, Boolean> recStack = new HashMap<>();

		while(verticies.iterator().hasNext()){
			int currentVertex = verticies.iterator().next();
			if(visited.get(currentVertex) == null){
				return dfs_cycle(currentVertex, visited, recStack);
			}
			
		}
		
		return false;

	}

	private boolean dfs_cycle(int vertex, Map<Integer, Boolean> visited, Map<Integer, Boolean> recStack){
		visited.computeIfAbsent(vertex, k-> true);
		recStack.computeIfAbsent(vertex, k-> true);

		for(int nei: this.graph.get(vertex)){
			if(visited.get(nei) == null ){
				if(dfs_cycle(nei, visited, recStack)){
					return true;
				}
			}

			if(recStack.get(nei) != null){
				return true;
			}
		}

		return false;
	}

	public static void main(String [] args){
		Graph g = new Graph();
		g.addEdge(0,1,true);
		g.addEdge(0,2,true);
		g.addEdge(1,2,true);
		g.addEdge(2,0,true);
		g.addEdge(2,2,true);
		g.addEdge(3,0,true);

		g.dfs(2);
		System.out.println();
		System.out.println(g.hasCycle());
	}
}