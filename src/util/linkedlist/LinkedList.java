package util.linkedlist;
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
}
public class LinkedList {
	
	public Node createLinkedList(int[] arr) {
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

	public Node createCircularLinkedList(int[] arr) {
		int i = 1;
		Node start = new Node(arr[0]);
		Node prev = start;
		while(i < arr.length){
			Node node = new Node(arr[i]);
			prev.next = node;
			prev = node;
			i++;
		}
		prev.next = start;
		return start;
	}
	
	public void printLinkedList(Node root) {
		while(root != null){
			System.out.print(root.data+" ");
			root = root.next;
		}
	}

	public void printCircularLinkedList(Node root) {
		Node start = root;
		do{
			System.out.print(root.data+" ");
			root = root.next;
		}while(root != start);
	}
}