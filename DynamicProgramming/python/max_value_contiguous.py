__author__ = "shashwat tiwari"
__email__  = "shashwat1791@gmail.com"


class MaxValueContiguous:

	def get_max_value_contiguous(self, arr):
		"""
			M[i] = M[i-1] + A[i], A[i]
		"""
		m = [-float('inf')]*len(arr)

		m[0] = arr[0]
		for i in range(1, len(arr)):
			m[i] = max(m[i-1]+arr[i], arr[i])
		return max(m)

	def max_contiguous_kadane(self, arr):
		"""
			store the start and end of the max contiguous subsequence as well, how would you do it?
		"""
		current_max = arr[0]
		max_sum = 0
		prev_max = 0

		start = 0
		end   = 0

		for i in range(1, len(arr)):
			if current_max + arr[i] < arr[i]:
				start = i
				current_max = arr[i]
			else:
				current_max = current_max + arr[i]

			max_sum = max(max_sum, current_max)
			if max_sum > prev_max:
				end = i
			prev_max = max_sum


		print start,end
		return max_sum





if __name__ == "__main__":
	print MaxValueContiguous().max_contiguous_kadane([7,-8,5,6,7,-2,1])