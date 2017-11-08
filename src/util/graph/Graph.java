package util.graph;

import java.util.LinkedList;

public class Graph {
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
	
	public LinkedList[] getAdjList(){
		return adj;
	}
}	
