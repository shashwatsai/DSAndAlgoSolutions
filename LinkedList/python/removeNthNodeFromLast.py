__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

"""
	Given a linked list, remove the n-th node from the end of list and return its head.

	Example:

	Given linked list: 1->2->3->4->5, and n = 2.

	After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:

	Given n will always be valid.

	Follow up:

	Could you do this in one pass?
	
"""

from LinkedList import LinkedList, ListNode

class Solution(object):


	def deleteNthNodeFromLast(self, head, n):

		fakeNode      = ListNode(-1)
		slow          = fakeNode
		fast          = fakeNode
		fakeNode.next = head

		# maintain a difference of n between slow and fast.
		for i in range(n+1):
			fast = fast.next

		while fast != None:
			fast  = fast.next
			slow  = slow.next

		to_del    = slow.next
		slow.next = slow.next.next
		del to_del

		return fakeNode.next

if __name__ == "__main__":
	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head,1, True)
	head = linked_list.insert(head,2, True)
	head = linked_list.insert(head,3, True)
	head = linked_list.insert(head,4, True)
	head = linked_list.insert(head,5, True)

	
	linked_list.printLL(head)
	res = Solution().deleteNthNodeFromLast(head, 2)
	print()
	linked_list.printLL(res)