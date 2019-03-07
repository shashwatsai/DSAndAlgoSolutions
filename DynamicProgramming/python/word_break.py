__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

class WordBreak:

	def __init__(self):
		pass

	def get_count(self, digits, n):
		# base case
		if n == 0 or n == 1:
			return 1

		count = 0
		if digits[n-1] > 0:
			count += self.get_count(digits, n-1)
		if digits[n-2] == 1 or (digits[n-1] < 7 and digits[n-2] == 2):
			count += self.get_count(digits, n-2)

		return count


if __name__ == "__main__":
	print WordBreak().get_count([1,2], 2)