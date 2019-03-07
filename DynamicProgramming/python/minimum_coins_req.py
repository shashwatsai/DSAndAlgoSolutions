__author__  = "shashwat tiwari"
__email__   = "shashwat1791@gmail.com"


class MinimumCoins:

	"""
		Subproblem: Minimum Number of coins required to get amount of j
		m[j] = min(m[j-v(i)]+1 for all i from 0 to len(denominations)
	"""

	def get_minimum_coins(self, coins, amount):
		MAX = float('inf')
		dp = [0] + [MAX] * amount

		for i in xrange(1, amount + 1):
			dp[i] = min([dp[i - c] if i - c >= 0 else MAX for c in coins]) + 1
		return [dp[amount], -1][dp[amount] == MAX]



if __name__ == "__main__":
	print MinimumCoins().get_minimum_coins([2,5],10)