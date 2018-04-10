__author__ = "Shashwat Tiwari"
__email__ = "shashwat1791@gmail.com"

"""
	An island is represented in an 2d array of size mxn. If robot moves out of island it gets
	destroyed and robot is allowed to move top, down, left, right. Given a robot position (x, y) 
	and k steps, what is the probability of robot getting survived in the effort of making 
	k steps.
"""

class Solution:
	def __init__(self):
		self.num_rows = 0
		self.num_cols = 0

	def check_validity_position(self, row, col):
		if row >= 0 and row < self.num_rows and col >= 0 and col < self.num_cols:
			return True
		return False


	def find_survival_probability(self, num_rows , num_cols , initial_position, number_of_steps):
		"""
			assuming island is zero indexed, example top left position will be considered (0,0)
		"""
		self.num_rows = num_rows
		self.num_cols = num_cols

		# hold valid moves
		valid_moves = 0
		# hold invalid moves
		invalid_moves = 0

		# we also assume that initial position robot is valid
		# otherwise we will have to handle that edge case

		bfs_queue = []
		bfs_queue.append(initial_position)
		# to store the end of level
		bfs_queue.append((None,None))

		while(len(bfs_queue)!=0 and number_of_steps > 0):

			curr_row, curr_col = bfs_queue.pop(0)
			if curr_row != None and curr_col != None:
				# check right move
				if(self.check_validity_position(curr_row, curr_col+1)):
					valid_moves += 1
					# if move is valid, enqueue the new valid move
					bfs_queue.append((curr_row, curr_col+1))
				else:
					invalid_moves += 1

				# check left move
				if(self.check_validity_position(curr_row, curr_col-1)):
					valid_moves += 1
					# if move is valid, enqueue the new valid move
					bfs_queue.append((curr_row, curr_col-1))
				else:
					invalid_moves += 1

				# check top move
				if(self.check_validity_position(curr_row-1, curr_col)):
					valid_moves += 1
					# if move is valid, enqueue the new valid move
					bfs_queue.append((curr_row-1, curr_col))
				else:
					invalid_moves += 1

				# check down move
				if(self.check_validity_position(curr_row+1, curr_col)):
					valid_moves += 1
					# if move is valid, enqueue the new valid move
					bfs_queue.append((curr_row+1, curr_col))
				else:
					invalid_moves += 1	
			else:
				if(len(bfs_queue)!=0):
					bfs_queue.append((None,None))
				number_of_steps -= 1


		total_moves = valid_moves + invalid_moves
		# Debug
		print((valid_moves, valid_moves+ invalid_moves))
		probability = valid_moves/(invalid_moves+valid_moves)

		return probability

if __name__ == "__main__":

	testcase = Solution().find_survival_probability(3,3,(0,0), 2)
	
	#please check with some input like (3,3,(0,1), 1), (3,3,(2,1), 1) 
	#It's returning 0. Which is ideally not true. as probability it should not return 0 or 1. 
	# it can be any value from 0 to 1. for any input it's returning either 0 or 1. 
	
	print(testcase)
