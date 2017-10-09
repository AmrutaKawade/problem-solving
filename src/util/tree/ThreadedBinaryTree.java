package util.tree;

public class ThreadedBinaryTree {
	public static Node createThreadedTree(Node root){
		if(root.left == null && root.right == null){
			return root;
		}
		Node temp = createThreadedTree(root.left);
		temp.right = root;
		temp.isThreaded = true;
		return createThreadedTree(root.right);
		
	}
	public static Node getLeftNode(Node node){
		while(node != null && node.left != null){
			node = node.left;
		}
		return node;
	}
	public static void inorderTraversal(Node root){
		Node current = getLeftNode(root);
		while(current != null){
			System.out.println(current.data);
			if(current.isThreaded)
				current = current.right;
			else{
				current = getLeftNode(current.right);
			}
		}
	}
	public static void main(String[] args) {
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    createThreadedTree(root);
	    inorderTraversal(root);
	}
}
