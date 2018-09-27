__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"


from collections import defaultdict

class Graph:

	def __init__(self):
		self.graph = defaultdict(list)

	def addEdge(self, source, destination, directed=False):
		if not directed:
			self.graph[destination].append(source)
		self.graph[source].append(destination)

	def dfs_util(self, vertex, visited):
		visited[vertex] = True
		print vertex,

		for nei in self.graph[vertex]:
			if visited[nei] == False:
				self.dfs_util(nei, visited)

	def dfs(self, source):
		visited = [False]*(len(self.graph))
		self.dfs_util(source, visited)


if __name__ == "__main__":
	graph = Graph()
	graph.addEdge(0,1)
	graph.addEdge(0,2)
	graph.addEdge(1,2)
	graph.addEdge(2,0)
	graph.addEdge(2,2)
	graph.addEdge(3,0)
	graph.dfs(2)
