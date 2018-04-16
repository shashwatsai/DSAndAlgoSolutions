__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"

from LinkedList import LinkedList, ListNode


"""
	Proof:

	You can prove that: say A length = a + c, B length = b + c, after switching pointer, 
	pointer A will move another b + c steps, pointer B will move a + c more steps, 
	since a + c + b + c = b + c + a + c, it does not matter what value c is. 
	Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL.

	example 
			a
			1-2-3
	             \
	              4-5
	             /
	          6-7
	          b

	    len(A) = 3 + 2
	    len(B) = 2 + 2
	    after switching pointer, b will move 3 + 2, which is a+c 
	    also, after switching pointer, a will move 2 + 2, which is b+c 

	    to reach the end. 
"""

class Solution(object):

	def findIntersectionNode(self, headA, headB):

		if headA == None or headB == None:
			return None 

		a = headA
		b = headB

		while a != b:
			a = headB if a == None else a.next
			if a is not None:
				print("a: "+str(a.val))
			else:
				print("a:null")
			b = headA if b == None else b.next
			if b is not None:
				print("b: "+str(b.val))
			else:
				print("b:null")
		return a

if __name__ == "__main__":

	headA                               = ListNode(1)
	headA.next                          = ListNode(2)
	headA.next.next                     = ListNode(3)
	headA.next.next.next = intersection = ListNode(4)
	headA.next.next.next.next           = ListNode(8)

	headB                          = ListNode(6)
	headB.next                     = ListNode(7)
	headB.next.next                = intersection
	headB.next.next.next           = ListNode(8)

	node = Solution().findIntersectionNode(headA, headB)
	print(node.val)