__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

class UserNode:

	def __init__(self, user_id, children, amount, parent_id):
		self.id = user_id
		self.children = children
		self.amount = amount
		self.parent_id = parent_id
		self.children_objects = []

	def get_parent_id(self):
		return self.parent_id

	def get_children(self):
		return self.children_objects

	def add_child(self, child):
		self.children_objects.append(child)

	def set_amount(self, amount):
		self.amount = amount

	def get_amount(self):
		return self.amount

class Referral:

	def __init__(self, snapshot, offers):
		self.snapshot = snapshot
		self.referral_offers = offers
		self.root = None
		self.users = {}

	def build_referral_tree(self):
		"""
			snapshot:
			[(user_id, list(children), current_earnings, parent_id)]
		"""
		for user_id, children, current_earnings, parent_id in self.snapshot:
			current_user = UserNode(user_id, children, current_earnings, parent_id)
			self.users[user_id] = current_user

		# update children objects
		for user_id in self.users:
			for child_id in self.users[user_id].children:
				self.users[user_id].add_child(self.users[child_id])

		# update root
		for user_id in self.users:
			if self.users[user_id].parent_id == None:
				self.root = self.users[user_id]

		#self.print_referral_tree(self.root)

	def add_referral(self, referred_by, referred_to):
		# get referred_by object
		referred_by_object = self.users[referred_by]
		# add referred to, its children
		new_user = UserNode(referred_to, [],0, referred_by)
		referred_by_object.add_child(new_user)
		self.users[referred_to] = new_user
		# update the amount for the all possible referral tree
		self.update_referral_tree(self.users[referred_to])

	def update_referral_tree(self, from_user):
		current = self.users[from_user.id]
		level = 0
		parent_id = from_user.get_parent_id()

		while parent_id != None:
			if level > len(self.referral_offers)-1:
				break
			parent = self.users[parent_id]
			parent.set_amount(parent.get_amount()+self.referral_offers[level])
			level += 1
			parent_id = parent.get_parent_id()



	def get_total_earnings_for_user(self, user_id):
		return self.users[user_id].get_amount()

	def print_referral_tree(self, root):
		if root != None:
			print "[" + str(root.id) + "], Reffered Following: [" +str(root.children)+ "], Was Referred By: [" + str(root.get_parent_id()) + "]"
			for child in root.get_children():
				self.print_referral_tree(child)


if __name__ == "__main__":
	current_snapshot = [
		('A1',['A2','A3'], 83, None),
		('A2',['A4','A5','A6'], 30, 'A1'),
		('A3',['A7'],44,'A1'),
		('A4',[],0,'A2'),
		('A5',[],0,'A2'),
		('A6',[],0,'A2'),
		('A7',['A8','A9'],34,'A3'),
		('A8',['A10'],19,'A7'),
		('A9',[],0,'A7'),
		('A10',['A11'],10,'A8'),
		('A11',[],0,'A10')
	]

	referral_offers = [10,9,5,11,6]
	test = Referral(current_snapshot, referral_offers)
	test.build_referral_tree()

	test.add_referral('A11','A12')
	print test.get_total_earnings_for_user('A8')


