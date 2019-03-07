__author__  = "shashwat tiwari"
__email__   = "shashwat1791@gmail.com"


class LIS:

	"""
		m[i] = max(m[j]) + 1 (for all j < i), if arr[i] > arr[j]
	"""
	def get_lis(self, arr):
		
		lis = [1]*len(arr)
		
		for i in range(1, len(arr)):
			lis[i] = max([lis[j]+1 if (lis[j]+1 > lis[i] and arr[i] > arr[j]) else lis[i]  for j in range(i)])
		return max(lis)

if __name__ == "__main__":
	print LIS().get_lis([1,3,5,6,8,9,3,6,0,12,21,8])