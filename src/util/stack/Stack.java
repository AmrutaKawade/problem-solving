package util.stack;

class Node {
	private int data;
	private Node next;
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

public class Stack {
	int capacity;
	static Node top = null;
	int length = 0;
	public Stack(int capacity) {
		super();
		this.capacity = capacity;
	}
	public boolean isFull(){
		return (length == (capacity-1));
	}
	public boolean isEmpty(){
		return length == 0;
	}
	public int pop(){
		if(isEmpty()){
			return -1;
		}
		int data = top.getData();
		top = top.getNext();
		length--;
		return data;
	}
	public void push(int data){	
		if(isFull()){
			return;
		}
		Node node = new Node(data);
		node.setNext(top);
		top = node;
		length++;
	}
}
