__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

from collections import defaultdict

class Graph:

	def __init__(self, number_of_verticies):
		self.graph = defaultdict(list)
		self.time  = -1
		self.arrival = [-1]*number_of_verticies
		self.departure = [-1]*number_of_verticies

	def addEdge(self, source, destination, isDirected=False):
		if not isDirected:
			self.graph[destination].append(source)
		self.graph[source].append(destination)

	def arrival_departure(self, vertex, visited):
		
		visited[vertex] = True
		self.time += 1
		self.arrival[vertex] = self.time

		for nei in self.graph[vertex]:
			if visited[nei] == False:
				self.arrival_departure(nei, visited)

		self.time += 1
		self.departure[vertex] = self.time


	def arrival_departure_interface(self):

		visited  = [False]*len(self.graph)

		for vertex in self.graph:
			if visited[vertex] == False:
				self.arrival_departure(vertex, visited)

	def print_graph(self):
		for vertex in self.graph:
			print vertex,
			for nei in self.graph[vertex]:
				print "("+str(nei)+")",
			print "start_time "+str(self.arrival[vertex])+" end_time " + str(self.departure[vertex])



if __name__ == "__main__":
	graph = Graph(4)
	graph.addEdge(0,1, True)
	graph.addEdge(1,2, True)
	graph.addEdge(1,3, True)
	graph.addEdge(2,3, True)
	graph.addEdge(2,1, True)
	graph.addEdge(3,0, True)

	graph.arrival_departure_interface()

	graph.print_graph()             