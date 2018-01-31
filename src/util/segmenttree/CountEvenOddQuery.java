package util.segmenttree;

import java.util.Scanner;

public class CountEvenOddQuery {
	
	static int[] arr = null;
	static int[] tree = null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int arrLen = in.nextInt();
		arr = new int[arrLen];
		
		int max_size = (int) Math.ceil(Math.log(arrLen)/Math.log(2));
		
		tree = new int[(int) (2*Math.pow(2, max_size))];
		
		for(int i = 0; i < arrLen; i++) {
			arr[i] = Integer.parseInt(in.next())%2;
		}
		//build
		build(0,0,arrLen-1);
		
		int queries = in.nextInt();
		for(int i = 0; i <= queries; i++) {
			String query = in.nextLine();
			String[] qArr = query.split(" ");
			
			if(!qArr[0].equals("") && Integer.parseInt(qArr[0]) == 0) {
				//update
				int x = Integer.parseInt(qArr[1]) - 1;
				int y = Integer.parseInt(qArr[2]);
				update(0,0,arrLen-1,x,y);
			}
			
			if(!qArr[0].equals("") && Integer.parseInt(qArr[0]) == 1) {
				//query count even numbers	
				int l = Integer.parseInt(qArr[1]) - 1;
				int r = Integer.parseInt(qArr[2]) - 1;
				System.out.println((r-l+1)-query(0,0,arrLen-1,l,r));
			}
			
			if(!qArr[0].equals("") && Integer.parseInt(qArr[0]) == 2) {
				//query count odd numbers
				int l = Integer.parseInt(qArr[1]) - 1;
				int r = Integer.parseInt(qArr[2]) - 1;
				System.out.println(query(0,0,arrLen-1,l,r));
			}
		}
		
	}
	
	private static int query(int node, int start, int end, int l, int r) {
		if(l > end || r < start) {
			return 0;
		}
		if(l <= start && end <= r) {
			return tree[node];
		}
		int mid = (start+end)/2;
		int q1 = query(2*node+1, start, mid, l, r);
		int q2 = query(2*node+2, mid+1, end, l, r);
		return q1+q2;
	}

	private static void update(int node, int start, int end, int x, int y) {
		if(start == end) {
			tree[node] = y%2;
			arr[x] = y%2;
			return;
		}
		int mid = (start+end)/2;
		if(start <= x && x <= mid) {
			update(2*node+1, start, mid, x, y);
		}else {
			update(2*node+2, mid+1, end, x, y);
		}
		tree[node] = tree[2*node+1] + tree[2*node+2];
	}
	//node represents count of even numbers in range
	private static void build(int node, int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		build(2*node+1, start, mid);
		build(2*node+2, mid+1, end);
		tree[node] = tree[2*node+1] + tree[2*node+2];
	}
}
