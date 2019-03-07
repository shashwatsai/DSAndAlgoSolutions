__author__   = "Shashwat Tiwari"
__email__    = "shashwat1791@gmail.com"


class TotalWays(object):

	"""
		m number of rows
		n number of columsn

		Robot can move only in right or vertically down direction

		possible recurrence relation:
		f(m,n) = f(m,n-1) + f(m-1,n)
 	"""
	def get_total(self, m , n):

		if m < 1 or n < 1:
			return 0
		
		# base case
		if m == 1 or n == 1:
			return 1

		count = 0
		right = self.get_total(m-1,n)
		bottom = self.get_total(m, n-1)

		count = right + bottom

		return count



if __name__ == "__main__":
	print TotalWays().get_total(2,3)
