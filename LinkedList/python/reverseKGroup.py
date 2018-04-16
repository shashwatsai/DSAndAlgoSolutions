__author__ = "Shashwat Tiwari"
__email__ = "shashwat1791@gmail.com"

"""
	Practice: https://leetcode.com/problems/reverse-nodes-in-k-group/description/

	Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

	k is a positive integer and is less than or equal to the length of the linked list. 
	If the number of nodes is not a multiple of k then left-out nodes in the end should 
	remain as it is.

	Example:

		Given this linked list: 1->2->3->4->5

		For k = 2, you should return: 2->1->4->3->5

		For k = 3, you should return: 3->2->1->4->5

	Note:

		Only constant extra memory is allowed.
		You may not alter the values in the list's nodes, only nodes itself may be changed.
"""

from LinkedList import LinkedList, ListNode

class Solution(object):
    
    def reverseKGroup(self, head, k):
    	curr  = head
    	count = 0

    	while count != k and curr!= None:
    		curr = curr.next
    		count += 1

    	if count == k:
    		# we need to reverse the List
    		current = head
    		next = None
    		prev = None

    		"""
    			After Iteration 1:

    			None(prev) 1(current)->2(next)->3->4->5->@
    			None(prev)<-1(current) 2(next)->3->4->5->@
    			None<-1(prev) 2(current,next)->3->4->5->@
    			count = 1

    			After Iteration 2:

    			None<-1(prev) 2(current)->3(next)->4->5->@
    			None<-1<-2(prev) 3(current,next)->4->5->@
    			count = 0


    		"""
    		while count > 0 and current != None:
    			next = current.next                    
    			current.next = prev
    			prev = current
    			current = next 
    			count -= 1

    		if next != None:
    			head.next = self.reverseKGroup(next, k)
    		head = prev 

    	return head

if __name__ == "__main__":
	head = None
	linked_list = LinkedList()
	head = linked_list.insert(head,1, True)
	head = linked_list.insert(head,2, True)
	head = linked_list.insert(head,3, True)
	head = linked_list.insert(head,4, True)
	head = linked_list.insert(head,5, True)

	
	linked_list.printLL(head)
	print()
	res = Solution().reverseKGroup(head, 2)
	linked_list.printLL(res)
