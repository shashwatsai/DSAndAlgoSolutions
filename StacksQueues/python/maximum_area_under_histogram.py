__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"


class AreaUnderHistogram:

	def find_max_area(self, hist):
		
		positions = []

		i = 0
		current_max_area = 0
		max_area  = 0
		
		while i < len(hist):
			# if the positions stack is empty or current histogram is more than top of stack
			if len(positions) == 0 or hist[positions[len(positions)-1]] < hist[i]:
				positions.append(i)
				i += 1
			else:
				tp = positions[len(positions)-1]
				positions.pop()

				current_max_area = hist[tp]*(i if len(positions)==0 else (i-positions[len(positions)-1]-1))
				if current_max_area > max_area:
					max_area = current_max_area

		while len(positions) != 0:
			tp = positions[len(positions)-1]
			positions.pop()

			current_max_area = hist[tp]*(i if len(positions)==0 else (i-positions[len(positions)-1]-1))
			if current_max_area > max_area:
				max_area = current_max_area

		return max_area


if __name__ == "__main__":
	hist = [2,1,7,8,2,3]
	print AreaUnderHistogram().find_max_area(hist)