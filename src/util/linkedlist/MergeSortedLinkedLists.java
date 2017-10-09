package util.linkedlist;
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
}
public class MergeSortedLinkedLists {
	public static Node mergeLinkedList(Node head1, Node head2){
		Node curr1 = head1;
		Node curr2 = head2;
		Node prev = null;
		Node start = null;
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		Boolean isStartNode = true;
		while(curr1 != null && curr2 != null){
			while(curr1 != null && curr2 != null && curr1.data >= curr2.data){
				if(isStartNode){
					start = curr2;
					isStartNode =  false;
				}
				prev = curr2;
				curr2 = curr2.next;
			}
			if(prev != null)
				prev.next = curr1;
			while(curr1 != null && curr2 != null && curr1.data < curr2.data){
				if(isStartNode){
					start = curr1;
					isStartNode =  false;
				}
				prev = curr1;
				curr1 = curr1.next;
			}
			if(prev != null)
				prev.next = curr2;
		}
		if(curr1 == null && curr2 != null){
			prev.next = curr2;
		}
		if(curr2 == null && curr1 != null){
			prev.next = curr1;
		}
		return start;
	}
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,11,11,13};//{1,10,15,19,20,25,26,30};
		int[] arr2 = {2,4,6,8,9,10,11,12,14,15,16};//{2,3,6,10,15,21,28};
		Node one = createLinkedList(arr1);
		Node two = createLinkedList(arr2);
		
		Node root = mergeLinkedList(one,two);
		printLinkedList(root);
	}
	private static void printLinkedList(Node root) {
		while(root != null){
			System.out.println(root.data);
			root = root.next;
		}
	}
	private static Node createLinkedList(int[] arr) {
		int i = 1;
		Node start = new Node(arr[0]);
		Node prev = start;
		while(i < arr.length){
			Node node = new Node(arr[i]);
			prev.next = node;
			prev = node;
			i++;
		}
		return start;
	}
}
