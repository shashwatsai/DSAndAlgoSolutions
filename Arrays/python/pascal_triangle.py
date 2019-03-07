__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

class Solution:

	def get_pascal_triangle(self, n):
		line = [[0 for i in range(n+1)] for j in range(n+1)]
		line[0][0] = 1

		for i in range(n+1):
			for j in range(i+1):
				if j == 0 or j == i:
					line[i][j] = 1
				else:
					line[i][j] = line[i-1][j-1] + line[i-1][j]

		for l in line:
			print l

	def get_kth_line(self, k):
		row = [0]*(k+1)
		
		row[0] = 1

		for line in range(k+1):
			for i in range(line,-1,-1):
				if i == 0 or i == line:
					row[i] = 1
				else:
					row[i] = row[i-1]+row[i]

		print row

if __name__ == "__main__":
	Solution().get_pascal_triangle(4)
	Solution().get_kth_line(4)