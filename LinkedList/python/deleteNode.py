__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

from LinkedList import LinkedList, ListNode

class Solution(object):
	
	def deleteNode(self, node):

		if node.next == None:
			return 

		nt        = node.next
		node.val  = nt.val
		node.next = nt.next

if __name__ == "__main__":

	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head, 1, True)
	head = linked_list.insert(head, 2, True)
	head = linked_list.insert(head, 3, True)
	head = linked_list.insert(head, 4, True)
	head = linked_list.insert(head, 5, True)

	Solution().deleteNode(head)
	linked_list.printLL(head)
		