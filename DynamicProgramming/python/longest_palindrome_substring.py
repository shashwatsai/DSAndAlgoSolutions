__author__ = "Shashwat Tiwari"
__email__  = "Shashwat1791@gmail.com"


class Longest_Palindromic_Substring(object):

	def __init__(self):
		pass


	def get_lps_length(self, input):
		n = len(input)
		lookup = [[False for x in range(n)] for y in range(n)]
		
		# handle case of length 1
		for i in range(n):
			lookup[i][i] = True

		# handle length 2 cases:
		start = 0;
		max_length = 0;
		for i in range(n-1):
			if input[i] == input[i+1]:
				lookup[i][i+1] = True
				start = i
				max_length = 2

		for k in range(3, n+1):

			for i in range(0, n-k+1):
				j = i + k -1
				if lookup[i+1][j-1] == True and input[i] == input[j]:
					lookup[i][j] = True

					if k > max_length:
						max_length = k
						start = i


		return input[start:start+max_length]

if __name__ == "__main__":
	print Longest_Palindromic_Substring().get_lps_length("forgeeksskeegfor")