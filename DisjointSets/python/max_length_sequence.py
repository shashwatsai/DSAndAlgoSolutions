__author__ = "shashwat tiwari"
__email__  = "shashwat1791@gmail.com"


class Subset(object):

	def __init__(self, parent):
		self.parent = parent
		self.rank = 1
		self.size = 1

class Solution(object):

	def __init__(self, arr):
		self.arr = arr
		self.subsets = [0]*len(arr)
		self.max_size = 1
		self.map = {}

	def initialize_subsets(self):
		for x in range(len(self.arr)):
			self.subsets[x] = Subset(x)

	def find(self, x):
		while x != self.subsets[x].parent:
			x = self.subsets[x].parent

		return x

	def union(self, x, y):
		p_x = self.find(x)
		p_y = self.find(y)

		if(p_x != p_y):
			if self.subsets[p_x].rank < self.subsets[p_y].rank:
				self.subsets[p_x].parent = p_y
				self.subsets[p_y].rank += 1
				self.subsets[p_y].size += self.subsets[p_x].size
				if self.subsets[p_y].size > self.max_size:
					self.max_size = self.subsets[p_y].size
			elif self.subsets[p_x].rank > self.subsets[p_y].rank:
				self.subsets[p_y].parent = p_x
				self.subsets[p_x].rank += 1
				self.subsets[p_x].size += self.subsets[p_y].size
				if self.subsets[p_x].size > self.max_size:
					self.max_size = self.subsets[p_x].size
			else:
				self.subsets[p_y].parent = p_x
				self.subsets[p_x].rank += 1
				self.subsets[p_x].size += self.subsets[p_y].size
				if self.subsets[p_x].size > self.max_size:
					self.max_size = self.subsets[p_x].size

	def get_max_size(self):

		for i in range(len(self.arr)):
			x = self.arr[i]
			if x-1 in self.map:
				self.union(i,self.map[x-1])

			if x+1 in self.map:
				self.union(i,self.map[x+1])

			self.map[x] =i

		return self.max_size

if __name__ == "__main__":
	arr = [1,3,4,5,2,12,8]
	sol = Solution(arr)
	sol.initialize_subsets()
	print sol.get_max_size()








