__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

"""
	Reference: https://community.topcoder.com/stat?c=problem_statement&pm=1901&rd=4650
"""

class FairWorkload:

	def get_workers_for_current_paritions(self, folders, workers, max_allocation_per_worker):
		worker = 1
		target = folders[0]

		for i in range(1, len(folders)):
			target  += folders[i]
			if target > max_allocation_per_worker:
				target  = folders[i]
				worker += 1

		return worker


	def getMostWork(self, folders, workers):

		low   = max(folders)
		high  = sum(folders)

		while low < high:
			mid             = (low + (high-low)//2)
			current_workers = self.get_workers_for_current_paritions(folders, workers, mid)
			if current_workers <= workers:
				high = mid
			else:
				low  = mid + 1

		return low



if __name__  == "__main__":
	folders = [568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782]
	workers = 4
	res = FairWorkload().getMostWork(folders, workers)
	print(res)