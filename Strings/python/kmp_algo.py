__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"


class KMPAlgorithm:

	def __init__(self):
		pass

	def search(self, text, pattern):
		
		i = 0
		j = 0
		lps = self.calculateLPS(pattern)

		while i < len(text):

			if text[i] == pattern[j]:
				i += 1
				j += 1

			if j == len(pattern):
				print "Pattern Found at index: {}".format(i-j)
				j = lps[j-1]
			elif i < len(text) and text[i] != pattern[j]: 
				if j != 0:
					j = lps[j-1]
				else:
					i += 1


	def calculateLPS(self, pattern):
		
		j      = 0
		i      = 1
		lps    = [0]*len(pattern)
		lps[0] = 0

		while i < len(pattern):
			if pattern[i] == pattern[j]:
				j += 1
				lps[i] = j
				i += 1
			else:
				if j != 0:
					j = lps[j-1]
				else:
					lps[i] = j
					i     += 1

		return lps 

if __name__ == "__main__":
	text    = "sssxsss"
	pattern = "sss"
	KMPAlgorithm().search(text, pattern)