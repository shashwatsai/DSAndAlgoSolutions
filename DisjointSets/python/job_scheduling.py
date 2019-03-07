__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

"""
Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.

Examples:

Input: Four Jobs with following deadlines and profits
  JobID    Deadline      Profit
    a        4            20   
    b        1            10
    c        1            40  
    d        1            30
Output: Following is maximum profit sequence of jobs
        c, a   


Input:  Five Jobs with following deadlines and profits
   JobID     Deadline     Profit
     a         2           100
     b         1           19
     c         2           27
     d         1           25
     e         3           15
Output: Following is maximum profit sequence of jobs
        c, a, e

"""

class Job(object):

	def __init__(self,job_name, job_deadline, job_profit):
		self.job_name = job_name
		self.job_deadline = job_deadline
		self.job_profit = job_profit

	def get_job_name(self):
		return self.job_name

	def get_job_profit(self):
		return self.job_profit

	def get_job_deadline(self):
		return self.job_deadline

class DisjointSets(object):

	def __init__(self, max_deadline):
		self.sets = [i for i in range(0,max_deadline+1)]
		
	def find(self, x):
		while self.sets[x] != x:
			x = self.sets[x]
		return x

	def union(self, u, v):
		self.sets[v] = u 


class JobScheduling(object):


	def __init__(self, jobs):
		self.jobs = jobs
		self.result = [] 

	def print_desired_jobs(self):
		# sor jobs based on profit
		jobs = sorted(self.jobs, key=lambda x:x.get_job_profit(), reverse=True)

		# get max deadline possible
		max_deadline = self.get_max_deadline(jobs)
		sets = DisjointSets(max_deadline)

		# get the maximum possible slot of highest profit
		for job in jobs:
			current_deadline = job.get_job_deadline()
			available_slot   = sets.find(current_deadline)

			if(available_slot > 0):
				# if the deadline is 3, we assign 2-3 time slot to the current job for instance
				sets.union(sets.find(available_slot-1), available_slot)
				self.result.append(job.get_job_name())

		return self.result


	def get_max_deadline(self, jobs):
		return max([j.get_job_deadline() for j in jobs])



if __name__ == "__main__":
	job_a = Job("a",2,100)
	job_b = Job("b",1,19)
	job_c = Job("c",2,27)
	job_d = Job("d",1,25)
	job_e = Job("e",3,15)

	jobs = [job_a, job_b, job_c, job_d, job_e];
	scheduling = JobScheduling(jobs)
	print scheduling.print_desired_jobs()
