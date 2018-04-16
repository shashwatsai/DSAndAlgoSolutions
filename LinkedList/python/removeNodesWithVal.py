__author__  = "Shashwat Tiwar"
__email__   = "shashwat1791@gmail.com"

"""
	Remove all elements from a linked list of integers that have value val.

	Example
	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
	Return: 1 --> 2 --> 3 --> 4 --> 5

"""
from LinkedList import LinkedList, ListNode

class Solution(object):

	def deleteNodesWithVal(self, head, val):
		if head == None:
			return head


		# case to handle till nodes from start have val as val
		while head!=None:
			if head.val == val:
				head = head.next
			else:
				break

		prev = head

		# handle case when all the elements have val as val, return None
		if prev == None:
			return None

		while prev.next != None:
			if prev.next.val  ==  val:
				prev.next = prev.next.next

			else:
				prev = prev.next

		return head


if __name__ == "__main__":
	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head, 1, True)
	head = linked_list.insert(head, 2, True)
	head = linked_list.insert(head, 3, True)
	head = linked_list.insert(head, 4, True)
	head = linked_list.insert(head, 5, True)
	head = linked_list.insert(head, 6, True)
	head = linked_list.insert(head, 7, True)
	head = linked_list.insert(head, 6, True)
	head = linked_list.insert(head, 9, True)
	head = linked_list.insert(head, 6, True)

	head = Solution().deleteNodesWithVal(head, 6)
	linked_list.printLL(head)