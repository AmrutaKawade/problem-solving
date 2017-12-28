package util.linkedlist;

public class SplitCircularLinkedList {
	static Node head,head1,head2;
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		LinkedList l = new LinkedList();
	   	head = l.createCircularLinkedList(arr);
		l.printCircularLinkedList(head);
		
		splitList();
		System.out.println();
		l.printCircularLinkedList(head1);
		System.out.println();
		l.printCircularLinkedList(head2);
	}
	
	
	private static void splitList() {
		Node slowPtr = head;
		Node fastPtr = head;
		do{
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}while(fastPtr.next != head);
		
		head1 = head;
		head2 = slowPtr.next;
		
		fastPtr.next = head2;
		slowPtr.next = head1;
	}
}
