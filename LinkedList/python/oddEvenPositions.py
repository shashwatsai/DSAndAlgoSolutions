__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

from LinkedList import LinkedList, ListNode

class Solution(object):

	def segregateOddEvenPositions(self, head):

		if head == None and head.next == None:
			return head
		
		odd      = head
		even     = head.next
		evenHead = even 

		while even != None and even.next != None:
			odd.next  = odd.next.next
			odd       = odd.next

			even.next = even.next.next
			even      = even.next

		odd.next  = evenHead
		return head

if __name__ == "__main__":

	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head,1, True)
	head = linked_list.insert(head,2, True)
	head = linked_list.insert(head,3, True)
	head = linked_list.insert(head,4, True)
	head = linked_list.insert(head,5, True)	

	res  = Solution().segregateOddEvenPositions(head)
	linked_list.printLL(res)