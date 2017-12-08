package util.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LinkNodesOfSameLevel {
	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6};
		Tree t = new Tree();
		Node root = t.createTree(array);
		t.inOrderTraversal(root);
		linkNodesOfSameLevel(root);
		System.out.println();
		printNextLevel(root);
	}

	private static void printNextLevel(Node node) {
		if(node == null){
			return;
		}
		System.out.println(node.data +"->" + ((node.next != null) ? node.next.data : null));
		printNextLevel(node.left);
		printNextLevel(node.right);
	}

	private static void linkNodesOfSameLevel(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		int levelNodeCount = 1;
		Node prev = null;
		
		while(!queue.isEmpty()){
			int count = levelNodeCount;
			levelNodeCount = 0;
			while(count != 0){
				Node temp = queue.poll();
				count--;
				
				if(temp.left != null){
					queue.add(temp.left);
					levelNodeCount++;
				}
				
				if(temp.right != null){
					queue.add(temp.right);
					levelNodeCount++;
				}
				
				if(prev != null)
					prev.next = temp;
				prev = temp;
			}		
			prev = null;
		}
	}
}
