__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

from collections import OrderedDict

class Permutation:

	def permute(self, text):
		_map = OrderedDict()
		for ch in text:	
			if ch in _map:
				_map[ch] += 1
			else:
				_map[ch] = 1
		
		string = []
		count = []
		
		for item in _map:
			string.append(item)
			count.append(_map[item])

		result = ['']*len(text)
		result_set = []

		self.permute_util(string, count, 0, result, result_set)
		return result_set

	def permute_util(self, string, count, level, result, result_set):
		# base case
		if level == len(result):
			result_set.append(''.join(result))
			return 

		for i in range(len(string)):
			if count[i] == 0:
				continue

			result[level] = string[i]
			count[i] -= 1
			self.permute_util(string, count, level+1, result, result_set)
			count[i] += 1


if __name__ == "__main__":
	p = Permutation()
	result = p.permute("AABC")

	for x in result:
		print x
