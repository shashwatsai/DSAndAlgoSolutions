__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

class MaxValue:

	def __init__(self):
		self.val = 0

class RodCutting:

	"""
		Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
		Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of 
		the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22
		 (by cutting in two pieces of lengths 2 and 6)


		length   | 1   2   3   4   5   6   7   8  
		--------------------------------------------
		price    | 1   5   8   9  10  17  17  20
		And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

		length   | 1   2   3   4   5   6   7   8  
		--------------------------------------------
		price    | 3   5   8   9  10  17  17  20

	"""

	def __init__(self):
		self.maximum = 0

	def get_max_profit(self,prices, total_length):
		self.helper(total_length, prices, total_length, MaxValue())
		return self.maximum

	def helper(self, current_length, prices, total_length, m):
		# base cases, length == 0
		if total_length == 0:
			self.maximum = max(self.maximum, m.val)
			return 

		for i in range(current_length,-1,-1):
			if i <= total_length and i > 0:
				m.val += prices[i-1]
				self.helper(i, prices, total_length-i, m)
				m.val -= prices[i-1]



if __name__ == "__main__":
	prices = [, 5, 8, 9, 10, 17, 17, 20]
	length = len(prices)

	print RodCutting().get_max_profit(prices, length)