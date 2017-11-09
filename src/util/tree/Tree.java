package util.tree;

class Node {
	int data;
	Node left;
	Node right;
	boolean isThreaded;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class Tree {

	public Node createTree(Integer[] array) {	
		Node[] nodeList = new Node[array.length];
		Node node = null;
		for(int i = 0; i < (array.length/2); i++){
			if(nodeList[i] == null && array[i] != null){
				node = new Node(array[i]);
				nodeList[i] = node;
			}else{
				node = nodeList[i];
			}
			if((2*i+1) < array.length && array[2*i+1] != null){
				node.left = new Node(array[2*i+1]);
				nodeList[2*i+1] = node.left;
			}
			if((2*i+2) < array.length && array[2*i+2] != null){
				node.right = new Node(array[2*i+2]);
				nodeList[2*i+2] = node.right;
			}
		}	
		return nodeList[0];
	}

	public void inOrderTraversal(Node node) {
		if(node == null){
			return;
		}else{
			inOrderTraversal(node.left);
			System.out.print(node.data+" ");
			inOrderTraversal(node.right);
		}
		
	}
}
