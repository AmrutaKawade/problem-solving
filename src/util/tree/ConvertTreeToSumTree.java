package util.tree;

public class ConvertTreeToSumTree {
	public static void main(String[] args) {
		Integer[] array = {10,-2,6,8,-4,7,5};
		Tree t = new Tree();
		Node root = t.createTree(array);
		t.inOrderTraversal(root);
		System.out.println();
		convertToSumTree(root);
		t.inOrderTraversal(root);
	}

	private static int convertToSumTree(Node node) {
		if(node == null){
			return 0;
		}
		int old_val = node.data;
		node.data = convertToSumTree(node.left) + convertToSumTree(node.right);
		return old_val + node.data;
		
		/*if(node.left == null && node.right == null){
			int data = node.data;
			node.data = 0;
			return data;
		}else if(node.left == null){
			int data = node.data;
			int temp = convertToSumTree(node.right);
			node.data = temp;
			return data+temp;
		}else if(node.right == null){
			int data = node.data;
			int temp = convertToSumTree(node.left);
			node.data = temp;
			return data+temp;
		}else{
			int data = node.data;
			int sum = convertToSumTree(node.left) + convertToSumTree(node.right);
			node.data = sum;
			return data+sum;
		}*/
	}
}
