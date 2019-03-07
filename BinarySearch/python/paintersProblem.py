__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

"""
	You have to paint N boards of length {A0, A1, A2, A3 .... AN-1} 
	There are K painters available and you are also given how much time a painter takes 
	to paint 1 unit of board. You have to get this job done as soon as possible under the 
	constraints that any painter will only paint contiguous sections of board.

	2 painters cannot share a board to paint. That is to say, a board
	cannot be painted partially by one painter, and partially by another.
	A painter will only paint contiguous boards. Which means a
	configuration where painter 1 paints board 1 and 3 but not 2 is
	invalid.

	Return the ans % 10000003

	Input :
	K : Number of painters
	T : Time taken by painter to paint 1 unit of board
	L : A List which will represent length of each board

	Output:
	     return minimum time to paint all boards % 10000003
	Example

	Input : 
	  K : 2
	  T : 5
	  L : [1, 10]
	Output : 50

"""

class Solution:

	def get_painters_for_config(self, number_of_painters, boards, mid):

		target     = boards[0]
		painters   = 1

		for i in range(1, len(boards)):
			target += boards[i]
			if target > number_of_painters:
				target    = boards[i]
				painters += 1

		return painters

	def get_required_painters(self, number_of_painters, boards):

		low   = max(boards)
		high  = sum(boards)

		while low < high:
			mid                     = (low + (high-low)//2)
			curr_number_of_painters = self.get_painters_for_config(number_of_painters, boards, mid)
			if curr_number_of_painters <= number_of_painters:
				high = mid
			else:
				low  = mid + 1

		return low


	def paint(self, number_of_painters, time_taken_to_paint, list_of_boards):

		res = self.get_required_painters(number_of_painters, list_of_boards)
		return (res*time_taken_to_paint)%10000003


if __name__ == "__main__":
	print(Solution().paint(2,5,[1,10]))