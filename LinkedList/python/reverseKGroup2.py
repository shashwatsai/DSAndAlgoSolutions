__author__ = "Shashwat Tiwari"
__email__ = "shashwat1791@gmail.com"

"""
	Given a linked list, reverse the nodes of a linked list k at a time alternatively and return its modified list.

	k is a positive integer and is less than or equal to the length of the linked list. 
	If the number of nodes is not a multiple of k then left-out nodes in the end should 
	remain as it is.

	Example:

		Given this linked list: 1->2->3->4->5->6->7->8->9->10

		For k = 2, you should return: 2->1->3->4->6->5->7->8->10->9

		For k = 3, you should return: 3->2->1->4->5->6->9->8->->7->10

	Note:

		Only constant extra memory is allowed.
		You may not alter the values in the list's nodes, only nodes itself may be changed.
"""

from LinkedList import LinkedList, ListNode

class Solution(object):

	def reverseKGroup2(self, head, k, flag):
		curr  = head
		count = 0

		while count != k and curr!= None:
			curr   = curr.next
			count += 1

		if count == k:
			current  = head
			next     = None
			prev     = None

			if flag:
				# we need to reverse the List
				while count > 0 and current != None:
					next         = current.next
					current.next = prev
					prev         = current
					current      = next
					count       -= 1
				
				if next != None:
					head.next = self.reverseKGroup2(next, k, not flag)
				head = prev

			else:
				while count > 0 and current != None:
					next         = current.next
					prev         = current
					current      = current.next
					count       -= 1
				if next != None:
					prev.next = self.reverseKGroup2(next, k, not flag)

		return head

if __name__ == "__main__":
	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head ,1,  True)
	head = linked_list.insert(head ,2,  True)
	head = linked_list.insert(head ,3,  True)
	head = linked_list.insert(head ,4,  True)
	head = linked_list.insert(head ,5,  True)
	head = linked_list.insert(head ,6,  True)
	head = linked_list.insert(head ,7,  True)
	head = linked_list.insert(head ,8,  True)
	head = linked_list.insert(head ,9,  True)
	head = linked_list.insert(head ,10, True)

	
	linked_list.printLL(head)
	res = Solution().reverseKGroup2(head, 2, True)
	print()
	linked_list.printLL(res)



