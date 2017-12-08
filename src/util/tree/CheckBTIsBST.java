package util.tree;

public class CheckBTIsBST {
	public static void main(String[] args) {
		Integer[] array = {3,2,5,1,4};
		Tree t = new Tree();
		Node root = t.createTree(array);
		t.inOrderTraversal(root);
		System.out.println();
		System.out.println(isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}

	private static boolean isBST(Node node, int max, int min) {
		if(node == null){
			return true;
		}
		if(node.data > max || node.data < min){
			return false;
		}
		return isBST(node.left,node.data,min) && isBST(node.right,max,node.data);	
	}	
}
