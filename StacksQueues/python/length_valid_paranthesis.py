__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"


class LengthValidParam(object):

	def get_max_valid_length(self,paran_str):
		stack = []
		last = -1
		i = 0
		max_len = 0
		while i < len(paran_str):
			if paran_str[i] == '(':
				stack.append(i)
			else:
				if len(stack) == 0:
					last = i
				else:
					stack.pop()
					if len(stack) == 0:
						max_len = max(max_len, i-last)
					else:	
						max_len = max(max_len, i-stack[len(stack)-1])
			i+=1
		return max_len


if __name__ == "__main__":
	test = LengthValidParam()
	print test.get_max_valid_length("()(())(")