__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

class SubsetSum:

	"""
		Given an array of positive integers

		[1,2,5]

		and a target sum

		6

		return whether a subset is present, which can add up to target sum

	"""

	def exponential_basic_approach(self, nums, target, index):

		if target == 0:
			return True

		if target > 0 and index < 0:
			return False

		# Do not include the current element
		if nums[index] > target:
			return self.exponential_basic_approach(nums, target, index-1)

		# do include the current element
		return self.exponential_basic_approach(nums, target, index-1) or self.exponential_basic_approach(nums, target-nums[index], index-1)

	def top_down_approach(self, nums, target):
		
		memo = [[None for i in range(target+1)] for j in range(len(nums))]
		return self.top_down_helper(nums, target, len(nums)-1, memo)
		
	def top_down_helper(self, nums, target, index, memo):
		if target == 0:
			memo[index][target] = True
			return True

		if target > 0 and index < 0:
			memo[index][target] = False
			return False

		if memo[index][target] != None:
			return memo[index][target]

		if(self.top_down_helper(nums, target, index-1, memo) or self.top_down_helper(nums, target-nums[index], index-1, memo)):
			memo[index][target] = True
			return True

		memo[index][target] = False
		return False

	def bottom_up_approach(self, nums, target):
		
		dp = [[False for i in range(target+1)] for j in range(len(nums))]

		# Sum 0 is possible with empty set
		for i in range(len(nums)):
			dp[i][0] = True

		for i in range(1,target+1):
			dp[0][i] = True if nums[0] == i else False

		for i in range(1,len(nums)):
			for s in range(1,target+1):
				if dp[i-1][s]:
					dp[i][s] = dp[i-1][s]
				elif s >= nums[i]:
					dp[i][s] = dp[i-1][s-nums[i]]
		print dp
		return dp[len(nums)-1][target]



if __name__ == "__main__":
	#print SubsetSum().exponential_basic_approach([1,2,5],3,2)
	#print SubsetSum().top_down_approach([1,2,5],3)
	print SubsetSum().bottom_up_approach([1,2,5],3)