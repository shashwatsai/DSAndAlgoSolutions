__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

from collections import defaultdict

class Min_Window_Substring:

	def get_min_window(self, string, pattern):

		target = defaultdict(int)
		# fill the target map
		for x in pattern:
			target[x] += 1

		left = 0
		minleft = 0
		count = 0
		min_window = len(string) + 1

		for i in range(len(string)):
			if string[i] in target:
				target[string[i]] -= 1
				if target[string[i]] >= 0:
					count += 1

				while count == len(pattern):
					if(i-left+1 < min_window):
						min_window = i-left+1
						minleft = left 

					if string[left] in target:
						target[string[left]] += 1
						if target[string[left]] > 0:
							count -= 1

					left += 1

		if min_window > len(string):
			return ""
		return string[minleft:minleft+min_window]



if __name__ == "__main__":
	test = Min_Window_Substring()
	string = "this is a string"
	pat    = "isa"
	print test.get_min_window(string, pat)