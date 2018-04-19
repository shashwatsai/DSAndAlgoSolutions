__author__   = "Shashwat Tiwari"
__email__    = "shashwat1791@gmail.com"

"""
	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

	(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

	You are given a target value to search. If found in the array return its index, otherwise return -1.

	You may assume no duplicate exists in the array.

	Your algorithm's runtime complexity must be in the order of O(log n).

	Example 1:

	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4
	Example 2:

	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1

"""

class Solution(object):

	def rotatedSearch(self, arr, target):

		low   = 0
		high  = len(arr)-1

		while low <= high:
			mid = (low + (high-low)//2)
			if arr[mid] == target:
				return mid

			elif arr[mid] >= arr[low]:
				if target >= arr[low] and target < arr[mid]:
					high = mid-1
				else:
					low  = mid+1
			elif arr[mid] <= arr[high]:
				if target <= arr[high] and target > arr[mid]:
					low  = mid+1
				else:
					high = mid-1

		return -1

if __name__   == "__main__":
	arr    = [4,5,6,6,7,7,0,1,2]
	target = 0
	print(Solution().rotatedSearch(arr, target))

