import java.io.*;
import java.util.*;

/*
    ### [Challenge Name: BFS: Shortest Reach in a Graph](/challenges/ctci-bfs-shortest-reach)


    Consider an undirected graph consisting of $n$ nodes where each node is labeled from $1$ to $n$ and the edge between any two nodes is always of length $6$. We define node $s$ to be the starting position for a BFS.  Given a graph, determine the distances from the start node to each of its descendants and return the list in node number order, ascending.  If a node is disconnected, it's distance should be $-1$.

    For example, there are $n = 6$ nodes in the graph with a starting node $s = 1$.  The list of $edges = [[1,2],[2,3],[3,4],[1,5]]$, and each has a weight of $6$.  


    ![image](https://s3.amazonaws.com/hr-assets/0/1528143002-2e9a521ad9-bfs_shortestExample.png)

    Starting from node $1$ and creating a list of distances, for nodes $2$ through $6$ we have $distances = [6, 12, 18, 6, -1]$.  

    **Function Description**

    Define a Graph class with the required methods to return a list of distances.  

*/

class Graph {
    int verticies;
    HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

    Graph(int verticies) {
        this.verticies = verticies;
    }

    public void addEdge(int source, int destination) {
        edges.computeIfAbsent(source, edges -> new ArrayList<>()).add(destination);
        // since this graph is undirected, add edges from destination to source
        edges.computeIfAbsent(destination, edges -> new ArrayList<>()).add(source);
    }

    public HashMap<Integer, ArrayList<Integer>> getEdges() {
        return this.edges;
    }

    private void initializeRes(int[] res) {
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
    }

    public int[] bfs(int source) {
        int[] res = new int[this.verticies + 1];
        int[] visited = new int[this.verticies + 1];
        initializeRes(res);
        initializeRes(visited);
        Queue<Integer> q = new LinkedList<>();

        // add the source
        q.offer(source);
        q.offer(null);

        visited[source] = 1;

        int level = 0;
        while (!q.isEmpty()) {
            Integer currentNode = q.poll();
            if (currentNode != null) {
                int distanceFromSource = level * 6;
                res[currentNode] = distanceFromSource;

                // add the adjacent nodes
                for (Integer nei : this.getEdges().get(currentNode)) {
                    if (visited[nei] == -1) {
                        q.offer(nei);
                        visited[nei] = 1;
                    }
                }

            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                level++;
            }
        }

        return res;
    }

}

public class BFSDistance {

    public static void main(String[] args) {
        Scanner sc = null;
        File file = new File("input1.txt");
        try {
            sc = new Scanner(file);
            // number of queries
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int n = sc.nextInt();
                int m = sc.nextInt();

                int source = -1;
                Graph g = new Graph(n);
                for (int j = 0; j < m; j++) {
                    int currentSource = sc.nextInt();
                    int currentDestination = sc.nextInt();
                    g.addEdge(currentSource, currentDestination);
                }
                source = sc.nextInt();
                System.out.println("Source: "+source);
                int[] res = g.bfs(source);
                for (int k = 1; k <= n; k++) {
                    if (k != source) {
                        System.out.print(res[k] + " ");
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            // handle the damn exception
        } finally {
            sc.close();
        }
    }
}
