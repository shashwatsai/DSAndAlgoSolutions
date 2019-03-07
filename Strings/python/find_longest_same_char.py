__author__ = "shashwat tiwari"
__email__  = "shashwat1791@gmail.com"


class Solution:

	def longest_consecutive_ele(self, string):
		if len(string) == 0:
			return ""

		count = 1
		start = 0
		max_len = 0
		s = -1
		e = -1
		for i in range(len(string)-1):
			if string[i] == string[i+1]: 
				count += 1
				if count > max_len:
					max_len = count
					s = start
					e = i+1
			else:
				count = 1
				start = i+1

		return string[s:e+1]


if __name__ == "__main__":
	print Solution().longest_consecutive_ele("aaaabbbcccc")