__author__ = "Shashwat Tiwari"
__email__ = "shashwat1791@gmail.com"


class ListNode(object):

	def __init__(self, val):
		self.val  = val
		self.next = None

class LinkedList(object):

	def insert(self, head, val, end=False):
		if head  == None:
			return ListNode(val)
		else:
			newNode = ListNode(val)
			if end:
				current = head
				while current.next!=None:
					current = current.next
				current.next = newNode
			else:
				newNode.next = head
				head = newNode

			return head

	def printLL(self, head):

		current = head
		while current != None:
			print(current.val,  end="->")
			current = current.next 

