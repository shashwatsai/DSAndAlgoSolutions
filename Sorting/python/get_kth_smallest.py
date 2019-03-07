__author__   = "Shashwat Tiwari"
__email__    = "shashwat1791@gmail.com"

class KthSmallest(object):

	def __init__(self):
		pass

	def get_kth_smallest(self, arr, k):
		return self.quick_k_select(arr, 0, len(arr)-1, k)

	def quick_k_select(self, arr, l, r, k):
		
	    # If k is smaller than number of  
	    # elements in array 
	    if (k > 0 and k <= r - l + 1): 
	      
	        # Partition the array around last  
	        # element and get position of pivot 
	        # element in sorted array 
	        pos = self.get_pivot_element(arr, l, r) 
	  
	        # If position is same as k 
	        if (pos - l == k - 1): 
	            return arr[pos] 
	        if (pos - l > k - 1): # If position is more,  
	                              # recur for left subarray 
	            return kthSmallest(arr, l, pos - 1, k) 
	  
	        # Else recur for right subarray 
	        return kthSmallest(arr, pos + 1, r, 
	                            k - pos + l - 1) 
	  
	    # If k is more than number of 
	    # elements in array 


		return float('inf')

	def get_pivot_element(self, arr, start, end):

		pivot = arr[end]
		j = start
		for i in range(start, end):
			if(arr[i] <= pivot):
				arr[j], arr[i] = arr[i], arr[j]
				j += 1

		arr[j], arr[end] = arr[end], arr[j]
		return j


if __name__ == "__main__":
	test = KthSmallest()
	arr = [5,12,9,-2,4,10,-14]
	k = 1

	print test.get_kth_smallest(arr, k)


