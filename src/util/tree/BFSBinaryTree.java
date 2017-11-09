package util.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSBinaryTree {
	
	public void breadFirstTraversal(Node root){
		Queue<Node> q = new LinkedList();
		q.add(root.left);
		q.add(root.right);
		
		System.out.println(root.data);
		
		while(!q.isEmpty()){
			Node temp = q.poll();
			System.out.println(temp.data);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	public static void main(String[] args) 
    {
        BFSBinaryTree tree = new BFSBinaryTree();
  
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
  
        System.out.println("BFS of tree is : ");
        tree.breadFirstTraversal(root);
    }
}
