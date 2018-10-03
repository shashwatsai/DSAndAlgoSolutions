import java.util.*;

public class ConnectedCities{
   	
   	private static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

	ConnectedCities(){
		graph = new HashMap<>();
	}

 	private static int gcd(int a, int b){
   		if(b == 0){
   			return a;
   		}else{
			return gcd(b, a%b);
   		}
	}

	private static void addEdge(int source, int destination, boolean directed){
		ArrayList<Integer> nodesFromSource = graph.get(source);
		if(nodesFromSource == null){
			nodesFromSource = new ArrayList<>();
			graph.put(source, nodesFromSource);
		}
		nodesFromSource.add(destination);

		// if it is not directed, make sure to add destination back to source in adjacency list
		if(!directed){
			ArrayList<Integer> nodesFromDestination = ConnectedCities.graph.get(destination);
			if(nodesFromDestination == null){
				nodesFromDestination = new ArrayList<>();
				graph.put(destination, nodesFromDestination);
			}
			nodesFromDestination.add(source);
		}
	}

	private static void dfsUtil(int vertex, Map<Integer, Boolean> visited, ArrayList<Integer> path){
		// mark visited
		visited.computeIfAbsent(vertex, k-> true);
		path.add(vertex);
		if(graph.get(vertex) != null){
			for(int nei : graph.get(vertex)){
				if(visited.get(nei) == null){
					dfsUtil(nei, visited, path);
				}
			}
		}

	}

	public static ArrayList<Integer> dfs(int source){
		Map<Integer, Boolean> visited = new HashMap<>();
		ArrayList<Integer> path = new ArrayList<>();
		dfsUtil(source, visited, path);
		return path;
	}
	
	public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
   		List<Integer> result = new ArrayList<>();

   		int size = originCities.size();

   		for(int i=1; i <= n; i++){
   			for(int j =1 ; j<=n; j++){
	   			
	   			if(gcd(i, j) > g){
	   				addEdge(i, j, false);
	   			} 	
	   		}

   		}

   		for(int i=0; i<size;i++){
   			int currentOriginCity = originCities.get(i);
   			int currentDestinationCity = destinationCities.get(i);

   			result.add(pathExists(currentOriginCity, currentDestinationCity));
   		}

   		return result;
   	}

   	private static int pathExists(int s, int d){
   		if(dfs(s).contains(d)){
   			return 1;
   		}

   		return 0;
   	}

	public static void main(String [] args){
		// number of cities 
		int n = 6;
		// threshold
		int g = 0;

		List<Integer> originCities = new ArrayList<>();
		originCities.add(1);originCities.add(4);originCities.add(3);originCities.add(6);
		List<Integer> destinationCities = new ArrayList<>();
		destinationCities.add(3);destinationCities.add(6);destinationCities.add(2);destinationCities.add(5);

		System.out.println(ConnectedCities.connectedCities(n,g,originCities,destinationCities));
	}
}