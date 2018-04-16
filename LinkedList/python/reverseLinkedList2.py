__author__ = "Shashwat Tiwari"
__email__ = "shashwat1791@gmail.com"

"""
	Reverse a linked list from position m to n. Do it in-place and in one-pass.

	For example:
	Given 1->2->3->4->5->NULL, m = 2 and n = 4,

	return 1->4->3->2->5->NULL.

	Note:
	Given m, n satisfy the following condition:
	1 ≤ m ≤ n ≤ length of list.

"""

from LinkedList import LinkedList, ListNode

class Solution(object):

	def reverseLinkedListBetween(self, head, m, n):

		fakeNode              = ListNode(-1)
		fakeNode.next         = head
		prev                  = fakeNode
		current               = head

		pos = 1
		while pos < m and current != None:
			prev              = current
			current           = current.next
			pos              += 1

		while pos < n and current != None:
			nt                = current.next.next
			current.next.next = prev.next
			prev.next         = current.next
			current.next      = nt 
			pos              += 1

		return fakeNode.next


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
	head = linked_list.insert(head, 8, True)
	head = linked_list.insert(head, 9, True)
	head = linked_list.insert(head,10, True)

	
	res = Solution().reverseLinkedListBetween(head, 1, 2)
	linked_list.printLL(res)
