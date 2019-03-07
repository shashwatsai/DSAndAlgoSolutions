__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

class CoinChange:

	def __init__(self):
		self.res = 0

	def helper(self, coins, change_needed, index):
		if change_needed == 0:
			self.res +=1 

		if index < 0:
			return 0

		if index < 0 and change_needed > 0:
			return 0

		for i in range(index, -1,-1):
			if coins[i] <= change_needed:
				change_needed = change_needed-coins[i]
				#print "helper("+str(coins)+","+str(change_needed+coins[i])+","+str(coins[i])+")"
				self.helper(coins, change_needed, i)
				change_needed = change_needed+coins[i]

	def get_total_ways(self, coins, change_needed):
		coins.sort()
		self.helper(coins, change_needed,len(coins)-1)
		return self.res 


if __name__ == "__main__":
	print CoinChange().get_total_ways([3,1,2],4)