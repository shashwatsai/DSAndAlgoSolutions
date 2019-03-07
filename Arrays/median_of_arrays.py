__author__  = "shashwat tiwari"
__email__   = "shashwat1791@gmail.com"


class MedianOfSortedArrays:

	def mean(self, nums):
		return sum(nums, 0.0) / len(nums) 

		
	""" 
	a = [1,3,8,9,15]
	b = [7,11,18,19,21,25]
	
	given two arrays, find the median of two sorted arrays of unequal length

	"""
	def get_median(self, a, b):

		if len(a) > len(a):
			return self.get_median(b,a)

		x = len(a)
		y = len(b)

		start = 0
		end   = x

		while(start <= end):
			partition_x = (start+end)/2
			partition_y = ((x+y+1)/2) - partition_x

			max_left_x = -float('inf') if partition_x == 0 else a[partition_x-1]
			min_right_x = float('inf') if partition_x == x else a[partition_x]

			max_left_y = -float('inf') if partition_y == 0 else b[partition_y-1]
			min_right_y = float('inf') if partition_y == y else b[partition_y]

			if(max_left_x <= min_right_y and max_left_y <= min_right_x):
				if (x+y)%2 == 0:
					return self.mean([max(max_left_x,max_left_y),min(min_right_x,min_right_y)])
				else:
					return max(max_left_x, max_left_y)
			elif max_left_x > min_right_y:
				end = partition_x - 1
			else:
				start = partition_x + 1

		raise Error("Illegal Argument Exception, Arrays are not sorted")


if __name__ == "__main__":
	print MedianOfSortedArrays().get_median([ -50, -41, -40, -19, 5, 21, 28 ],[-50, -21, -10]) 