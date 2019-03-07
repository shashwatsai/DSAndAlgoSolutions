__author__ = "shashwat tiwari"
__email__  = "shashwat1791@gmail.com"

from collections import deque

class Solution:

	def get_max_in_window(self, arr, k):
		result = []
		dq = deque()
		if len(arr) < 1:
			return result 

		if len(arr) <= k:
			result.append(max(arr))

		# handle case of first window
		for i in range(k):
			while dq and arr[i] >= arr[dq[-1]]:
				dq.pop()
			dq.append(i)

		for i in range(k, len(arr)):
			# add the maximum for the previous window
			result.append(arr[dq[0]])

			# discard the outliers for the current window
			while dq and dq[0] <= i-k:
				dq.popleft()

			while dq and arr[i] >= arr[dq[-1]]:
				dq.pop()
			dq.append(i)

		result.append(arr[dq[0]])

		return result



if __name__ == "__main__":
	arr = [1,3,1,2,4,2,4,5]
	k = 3
	print Solution().get_max_in_window(arr, k)