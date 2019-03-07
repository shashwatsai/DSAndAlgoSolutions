__author__ = "shashwat tiwari"
__email__  = "shashwat1791@gmail.com"

import math
import sys

class SegmentTree:

	def __init__(self):
		pass

	def get_next_power_of_2(self, number):
		count = 0
		while number != 0:
			number = number >> 1;
			count += 1

		return int(math.pow(count,2))

	def initialize_segment_tree(self, arr):
		st_length = self.get_next_power_of_2(len(arr))*2-1
		segment_tree = [sys.maxint]*st_length

		self.build_segment_tree(segment_tree, arr, 0, len(arr)-1, 0)
		return segment_tree

	def build_segment_tree(self, segment_tree, input, start, end, pos):

		if start == end:
			segment_tree[pos] = input[start]
			return 

		mid = (start+end)//2	

		# recurse to the left and right half
		self.build_segment_tree(segment_tree, input, start, mid, 2*pos+1)
		self.build_segment_tree(segment_tree, input, mid+1, end, 2*pos+2)

		segment_tree[pos] = min(segment_tree[2*pos+1],segment_tree[2*pos+2])
		return 

	def range_min_query(self, segment_tree, start, end, qs, qe):
		return self.range_min_query_helper(segment_tree, qs, qe, start, end, 0)

	def range_min_query_helper(self, segment_tree, qs, qe, start, end, pos):
		if( qs <= start and qe >= end):
			return segment_tree[pos]

		if(qs > end or qe < start):
			return sys.maxint

		mid = (start+end)//2

		return min(self.range_min_query_helper(segment_tree, qs, qe, start, mid, 2*pos +1),self.range_min_query_helper(segment_tree, qs, qe, mid+1, end, 2*pos +2))



if __name__ == "__main__":
	st_instance = SegmentTree()
	st = st_instance.initialize_segment_tree([1,4,2,3,6,5,6])
	print st_instance.range_min_query(st, 0, 6, 1, 3)

