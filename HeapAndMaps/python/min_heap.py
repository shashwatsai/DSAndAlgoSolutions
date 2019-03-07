__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

class MinHeap:

	def __init__(self, arr):
		self.size = len(arr)
		self.heap = list(arr)

	def print_heap(self):
		if(self.heap == None or len(self.heap) == 0):
			raise Exception("Heap is None")
		print "[",
		for i in range(self.size):
			print self.heap[i],
		print "]"

	def build_min_heap(self):
		for i in range(self.size/2-1,-1,-1):
			self.min_heapify(i)

	def min_heapify(self, index):
		smallest = index
		left_index = 2*index + 1
		right_index = 2*index + 2

		if(left_index < self.size and self.heap[left_index] < self.heap[index]):
			smallest = left_index 

		if(right_index < self.size and self.heap[right_index] < self.heap[smallest]):
			smallest = right_index

		if(smallest != index):
			self.swap(smallest, index)
			self.min_heapify(smallest)

		return

	def swap(self, source, destination):
		self.heap[source], self.heap[destination] = self.heap[destination], self.heap[source]

	def find_min(self):
		if self.size == 0:
			raise Exception("Heap is None")
		return self.heap[0]

	def extract_min(self):
		if self.size == 0:
			raise Exception("Empty Heap")
		Min = self.heap[0]
		self.heap[0] = self.heap[self.size-1]
		self.min_heapify(0)
		self.size -=1
		return Min

	def insert(self, ele):
		i = self.size 
		parent_index = (i-1)/2

		while i > 0 and self.heap[parent_index] > ele:
			self.heap[i] = self.heap[parent_index]
			i = parent_index
			parent_index = (i-1)/2

		self.heap[i] = ele
		self.size += 1

		

if __name__ == "__main__":
	arr = [2, 4, 5, 1, 6, 7, 8]
	heap = MinHeap(arr)
	heap.print_heap()
	heap.build_min_heap()
	heap.print_heap()
	heap.extract_min()
	heap.print_heap()
	heap.extract_min()
	heap.print_heap()
	heap.extract_min()
	heap.print_heap()
	heap.extract_min()
	heap.print_heap()
	heap.extract_min()
	heap.insert(-10)
	heap.print_heap()
	heap.extract_min()
	heap.print_heap()
