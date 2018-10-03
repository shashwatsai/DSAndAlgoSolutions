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

	def hasCycle(self):

		white = set()
		grey  = set()
		black = set()

		for v in self.graph.keys():
			white.add(v)

		while len(white) > 0:
			current = next(iter(white))
			if(self.dfs_cycle(current, white, grey, black)):
				return True
		return False

	def dfs_cycle(self, vertex, white_set, grey_set, black_set):
		# Move from white to grey set
		self.move_vertex(vertex, white_set, grey_set)
		for nei in self.graph[vertex]:
			if nei in black_set:
				continue
			if nei in grey_set:
				return True
			if self.dfs_cycle(nei, white_set, grey_set,black_set):
				return True

		self.move_vertex(vertex, grey_set, black_set)
		return False




	def move_vertex(self, vertex, source_set, destination_set):
		source_set.remove(vertex)
		destination_set.add(vertex)




if __name__ == "__main__":
	graph = Graph()
	graph.addEdge(0,1)
	graph.addEdge(1,2)
	graph.addEdge(1,3)
	graph.addEdge(2,3)
	graph.addEdge(2,1)
	graph.dfs(2)

	print graph.hasCycle()
