package util.segmenttree;

import java.util.Scanner;

//https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
public class RangeMinimumQuery {
	static int[] tree = null;
	static int[] arr = null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arrLen = Integer.parseInt(in.next());
		int queries = Integer.parseInt(in.next());
		
		arr = new int[arrLen];
		
		//size = 2*2^logn-1
		tree = new int[3*arrLen];
		for(int i = 0; i < arrLen; i++) {
			arr[i] = Integer.parseInt(in.next());
		}
		//build(rootNode, startIndex, endIndex)
		build(0,0,arrLen-1);
		
		for(int i = 0; i <= queries; i++) {
			String query = in.nextLine();
			String[] qArr = query.split(" ");
			if(qArr[0].equals("q")) {
				int l = Integer.parseInt(qArr[1])-1;
				int r = Integer.parseInt(qArr[2])-1;
				//query(rootNode,startIndex,endIndex,left,right)
				int min = query(0,0,arrLen-1,l,r);
				System.out.println(min);
			}
			if(qArr[0].equals("u")) {
				int index = Integer.parseInt(qArr[1])-1;
				int val = Integer.parseInt(qArr[2]);
				//update(rootNode,startIndex,endIndex,index,value)
				update(0,0,arrLen-1,index,val);
			}
		}
	}

	private static void update(int node, int start, int end, int index, int val) {
		if(start == end) {
			arr[index] = val;
			tree[node] = val;
			return;
		}
		int mid = (start+end)/2;
		if(start <= index && index <= mid) {
			update(2*node+1, start, mid, index, val);
		}else {
			update(2*node+2, mid + 1, end, index, val);
		}
		tree[node] = Math.min(tree[2*node+1],tree[2*node+2]);
	}

	private static int query(int node, int start, int end, int l, int r) {
		//out of range
		if(l > end || r < start) {
			return Integer.MAX_VALUE;
		}
		//within range
		if(l <= start && end <= r) {
			return tree[node];
		}
		//partially inside partially outside of given range
		int mid = (start+end)/2;
		int q1 = query(2*node+1,start,mid,l,r);
		int q2 = query(2*node+2,mid+1,end,l,r);
		return Math.min(q1, q2);
	}

	private static void build(int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		build(2*node+1, start, mid);
		build(2*node+2, mid+1, end);
		tree[node] = Math.min(tree[2*node+1],tree[2*node+2]);
	}
}
