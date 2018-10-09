__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"


class PermuteString(object):

	def __init__(self, arg):
		super(PermuteString, self).__init__()
		self.arg = arg

	def permute(self):
		self.permute_util(0, len(self.arg))

	def permute_util(self, l, r):
		if l == r:
			print self.arg

		for i in range(l, r):
			self.arg[i],self.arg[l] = self.arg[l], self.arg[i]
			self.permute_util(l+1, r)
			self.arg[i],self.arg[l] = self.arg[l], self.arg[i]

if __name__ == "__main__":
	string = ['A','B','C','D']
	PermuteString(string).permute()
		

