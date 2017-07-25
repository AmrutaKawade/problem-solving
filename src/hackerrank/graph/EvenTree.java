package hackerrank.graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/even-tree/problem
class Graph{
	private int ans;
	private int V;
	private LinkedList[] adj;
	
	public Graph(int v){
		V = v;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList();
		}
	}

	public void addEdge(int i, int j) {
		adj[i].add(j);
	}
	public int DFS(int n){
		boolean visited[] = new boolean[V];
		DFSUtil(n,visited);
		return ans;
	}

	private int DFSUtil(int node, boolean[] visited) {
		int num = 0;
		int temp = 0;
		visited[node] = true;
		
		ListIterator list = adj[node].listIterator();
		while(list.hasNext()){
			int n = (int) list.next();
			if(!visited[n]){
				temp = DFSUtil(n, visited);
				if(temp%2==0){
					ans++;
				}
				else{
					num += temp;
				}
			}
		}
		return num+1;
	}
}
public class EvenTree {
	public static void main(String[] args) {
		//As array indexing starts from 0. node 10 gives arraindexoutofbound excp
		//thats why 10+1
		/*Graph g = new Graph(11);	
		g.addEdge(1, 3);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(6, 8);
        g.addEdge(2, 7);
        g.addEdge(2, 5);
        g.addEdge(4, 9);
        g.addEdge(4, 10);
        
        System.out.println(g.DFS(1));
		*/
		Scanner in = new Scanner(System.in);		
		int vertices = in.nextInt();
		int edges = in.nextInt();
		Graph g = new Graph(vertices+1);
		for(int i=0;i<edges;i++){
			int j = in.nextInt();
			int k = in.nextInt();
			g.addEdge(j,k);
			g.addEdge(k, j);
		}
		System.out.println(g.DFS(1));
	}
}
