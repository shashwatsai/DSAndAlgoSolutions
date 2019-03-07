__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

class MaxValue:

	def __init__(self):
		self.val = 0

class UnboundedKnapsack:

	def __init__(self):
		self.maximum = 0
	"""
		
		Given a knapsack weight W and a set of n items with certain value vali and weight wti, 
		we need to calculate minimum amount that could make up this quantity exactly. 
		This is different from classical Knapsack problem, here we are allowed to use 
		unlimited number of instances of an item.


		Input : W = 100
       	val[]  = {1, 30}
       	wt[] = {1, 50}
		Output : 100
		There are many ways to fill knapsack.
		1) 2 instances of 50 unit weight item.
		2) 100 instances of 1 unit weight item.
		3) 1 instance of 50 unit weight item and 50
		   instances of 1 unit weight items.
		We get maximum value with option 2.

		Input : W = 8
		       val[] = {10, 40, 50, 70}
		       wt[]  = {1, 3, 4, 5}       
		Output : 110 
		We get maximum value with one unit of
		weight 5 and one unit of weight 3.

	"""
	def unbounded_knapsack(self, weights, values, capacity):
		self.helper(weights, values, capacity, MaxValue())
		return self.maximum

	def helper(self, wt, val, W, m):
		if W == 0:
			# store max sum of vals
			self.maximum = max(self.maximum, m.val)
			return

		for i in range(len(wt)-1,-1,-1):
			if(wt[i] <= W):
				m.val += val[i]
				self.helper(wt, val, W-wt[i], m)
				m.val -= val[i]
		


if __name__ == "__main__":
	
	wt = [1, 3, 4, 5]
	val = [10, 40, 50, 70]
	weight = 8
	
	print UnboundedKnapsack().unbounded_knapsack(wt, val, weight)