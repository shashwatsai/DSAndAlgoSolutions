class ListNode{

	int val;
	ListNode next;

	public ListNode(int val){
		this.val = val;
		this.next = null;
	}
}

public class LinkedList{

	public ListNode insert(ListNode head, int val){
		// just insert at the head
		if(head == null){
			return new ListNode(val);
		}else{
			ListNode newNode = new ListNode(val);
			newNode.next = head;
			head = newNode;
		}

		return head;
	}

	public void printLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+"->");
			head = head.next;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n){
		if(head == null || head.next == null){
			return null;
		}

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode current = head;
		ListNode prev = fakeHead;

		int pos = 1;

		while(pos < m && current!=null){
			prev = current;
			current = current.next;
			pos++;
		}
		 //         nt 
		// 1->2->3->4->5
		while(pos < n && current != null){
			ListNode nt = current.next.next;
			current.next.next = prev.next;
			prev.next = current.next;
			current.next = nt;
			pos++;
		}

		return fakeHead.next;
	}

	public ListNode reverseLL(ListNode head){
		if(head == null){
			return null;
		}

		ListNode current = head;
		ListNode prev    = null;
		ListNode next    = null;

		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	public ListNode reverseInGroupK(ListNode head, int k){

		int count = 0;
		ListNode curr = head;

		while(count !=k && curr != null){
			curr = curr.next;
			count++;
		}

		if(count == k){
			ListNode current = head;
			ListNode next    = null;
			ListNode prev    = null;

			while(count > 0 && current != null){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
				count--;
			}

			if(next != null){
				head.next = reverseInGroupK(next, k);
			}

			head = prev;
		}

		return head;
	}

	public static void main(String [] args){
		ListNode head = null;
		LinkedList list = new LinkedList();
		head = list.insert(head, 5);
		head = list.insert(head, 4);
		head = list.insert(head, 3);
		head = list.insert(head, 2);
		head = list.insert(head, 1);

		list.printLL(head);
		System.out.println();
		head = list.reverseInGroupK(head,2);
		list.printLL(head);
		System.out.println();
	}
}