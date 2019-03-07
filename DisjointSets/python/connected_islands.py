__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

class Subset(object):

	def __init__(self, parent):
		self.parent = parent
		self.rank   = 0

class Solution(object):

	def __init__(self):
		self.subsets = list()

	def find(self, x):
		x -= 1
		while x != self.subsets[x].parent:
			x = self.subsets[x].parent

		return self.subsets[x].parent

	def union(self, a , b):

		p_a = self.find(a)
		p_b = self.find(b)

		if(p_a != p_b):
			if self.subsets[p_a].rank < self.subsets[p_b].rank:
				self.subsets[p_a].parent = p_b
				self.subsets[p_b].rank += 1
			else:
				self.subsets[p_b].parent = p_a
				self.subsets[p_a].rank += 1

	def min_cost(self, bridges, no_of_vertices):

		#bridges = sorted(bridges,key=lambda l:l[2])
		bridges.sort(key=lambda l:l[2])
		min_cost = 0
		
		for x in range(no_of_vertices):
			self.subsets.append(Subset(x))

		for bridge in bridges:
			node_a = bridge[0]
			node_b = bridge[1]
			cost   = bridge[2]

			if self.find(node_a) != self.find(node_b):
				self.union(node_a, node_b)
				min_cost += cost

		return min_cost


if __name__ == "__main__":

	no_of_vertices = 4

	bridges = [
		[1,2,1],
		[2,3,4],
		[1,4,3],
		[4,3,2],
		[1,3,10]
	]
	print Solution().min_cost(bridges, no_of_vertices)
