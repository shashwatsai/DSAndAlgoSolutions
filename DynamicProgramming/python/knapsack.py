__author__  = "shashwat tiwari"
__email__   = "shashwat1791@gmail.com"


class KnapSack:

	def get_max_value(self, weights, values, capacity):
		memo = [[None for i in range(capacity+1)] for j in range(len(weights))]
		return self.helper(weights, values, capacity, len(weights)-1, memo)

	def helper(self, weights, values, capacity, n, memo):
		if n == 0 or capacity == 0:
			memo[n][capacity] = 0
			return 0

		if memo[n][capacity] != None:
			return memo[n][capacity]	

		if weights[n] > capacity:
			result = self.helper(weights, values, capacity, n-1, memo)
		else:
			# current item taken
			current_taken = values[n] + self.helper(weights, values, capacity - weights[n],n-1, memo)
			# current item not taken
			current_not_taken = self.helper(weights, values, capacity, n-1, memo)

			result =  max(current_taken, current_not_taken)

		memo[n][capacity] = result
		return result

if __name__ == "__main__":
	print KnapSack().get_max_value([10,20,30],[60,10,120],50)
