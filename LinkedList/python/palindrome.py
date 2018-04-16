__author__ = "Shashwat Tiwari"
__email__ = "shashwat1791@gmail.com"

"""
	Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?
"""

from LinkedList import LinkedList, ListNode

class Solution(object):

	def isPalindrome(self, head):

		if head == None and head.next == None:
			return True
		
		slowPtr       = head
		fastPtr       = head
		prev_slow_ptr = None
		second_half   = None

		while fastPtr != None and fastPtr.next != None:
			fastPtr       = fastPtr.next.next
			prev_slow_ptr = slowPtr
			slowPtr       = slowPtr.next

		"""
			Handle cases separately for odd and even length List 

			odd lenght:
				fastPtr != None

		"""

		if fastPtr != None:
			slowPtr = slowPtr.next

		prev_slow_ptr.next = None
		second_half        = slowPtr

		second_half        = self.reverse(second_half)

		return self.compare(head, second_half)

	def compare(self, head1, head2):

		while head1 !=None and head2 != None:
			if head1.val != head2.val:
				return False
			head1 = head1.next
			head2 = head2.next


		return True


	def reverse(self, head):

		current   = head
		prev      = None
		next      = None

		while current != None:
			next         = current.next
			current.next = prev
			prev         = current
			current      = next

		return prev 





if __name__ == "__main__":

	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head,1, True)
	head = linked_list.insert(head,2, True)
	head = linked_list.insert(head,3, True)
	head = linked_list.insert(head,2, True)
	head = linked_list.insert(head,1, True)

	print(Solution().isPalindrome(head))