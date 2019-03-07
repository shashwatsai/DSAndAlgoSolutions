public class AddNumbersAsList{

	private static ListNode reverse(ListNode head){

		ListNode prev = null;
		ListNode next = null;
		ListNode curr = head;

		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	private static ListNode addLists(ListNode a, ListNode b){
		// reverse both the list
		a = reverse(a);
		b = reverse(b);

		int carry = 0;
		ListNode curr = new ListNode(-1);
		ListNode res = curr;
		while( a != null || b != null){
			int s = a.val + b.val + carry;
			curr.next = new ListNode(s%10);
			carry = s/10;
			curr = curr.next;
			a = a.next;
			b = b.next;
		}

		return reverse(res.next);
	} 

	public static void main(String [] args){
		ListNode head = null;
		LinkedList list = new LinkedList();
		head = list.insert(head, 5);
		head = list.insert(head, 6);
		head = list.insert(head, 3);


		ListNode head1 = null;
		LinkedList list1 = new LinkedList();
		head1 = list1.insert(head1, 8);
		head1 = list1.insert(head1, 4);
		head1 = list1.insert(head1, 2);

		ListNode res = addLists(head, head1);
		list.printLL(res);
	}
}