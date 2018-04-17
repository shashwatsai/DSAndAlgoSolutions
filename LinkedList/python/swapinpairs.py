__author__  = "Shashwat Tiwari"
__email__   = "shashwat1791@gmail.com"

"""
	Given a linked list, swap every two adjacent nodes and return its head.

	Example:

	Given 1->2->3->4, you should return the list as 2->1->4->3.
	Note:

	Your algorithm should use only constant extra space.
	You may not modify the values in the list's nodes, only nodes itself may be changed.

"""

from LinkedList import LinkedList, ListNode

class Solution(object):

	def swapPairs(self, head):

		curr   = head.next
		prev   = head

		next   = None
		head   = curr

		while True:

			next      = curr.next
			curr.next = prev

			if next == None or next.next == None:
				prev.next = next
				break

			prev.next  = next.next
			prev       = next
			curr       = prev.next

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
	head = linked_list.insert(head, 8, True)
	head = linked_list.insert(head, 9, True)
	head = linked_list.insert(head,10, True)

	head = Solution().swapPairs(head)
	linked_list.printLL(head)