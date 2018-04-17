__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

"""
	Practice : https://leetcode.com/problems/rotate-list/description/

	Example: 
	
	Input: 1->2->3->4->5->NULL, k = 2
	Output: 4->5->1->2->3->NULL
	Explanation:
	rotate 1 steps to the right: 5->1->2->3->4->NULL
	rotate 2 steps to the right: 4->5->1->2->3->NULL

	Concept: if l is the length of the list, and k is the number of roatation we need to make
	then, we need to move list after (l-k%l)th node

"""

from LinkedList import LinkedList, ListNode

class Solution(object):

	def rotateList(self, head, k):
		if head == None or head.next == None:
			return head

		fake_node      = ListNode(0)
		fake_node.next = head
		fast           = fake_node
		slow           = fake_node

		# calculate the length
		l = 0
		while fast.next != None:
			fast = fast.next
			l   += 1

		# we need to move the list after (l-k%l)th node
		node_pos = l-k%l
		while node_pos > 0:
			slow      = slow.next
			node_pos -= 1

		fast.next      = fake_node.next
		fake_node.next = slow.next
		slow.next      = None

		return fake_node.next


if __name__ == "__main__":
	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head, 1, True)
	head = linked_list.insert(head, 2, True)
	head = linked_list.insert(head, 3, True)
	head = linked_list.insert(head, 4, True)
	head = linked_list.insert(head, 5, True)
	head = linked_list.insert(head, 6, True)

	res  = Solution().rotateList(head, 2)
	linked_list.printLL(res)