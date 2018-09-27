class Solution(object):

	def __init__(self):
		pass

	def left_rotate(self, arr, n, by):
		for i in range(by):
			self.left_rotate_by_one(arr, n)

	def left_rotate_by_one(self, arr, n):
		temp = arr[0]
		for i in range(n-1):
			arr[i] = arr[i+1]
		arr[n-1] = temp

if __name__ == "__main__":
	arr = [1,2,3,4,5,6]
	Solution().left_rotate(arr, 6, 2)
	print arr