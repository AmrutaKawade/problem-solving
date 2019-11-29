package util.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class GraphMST {
	private int V;
	private LinkedList[] adj;
	
	public GraphMST(int v){
		V = v;
		adj = new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(int i, Edge j) {
		adj[i].add(j);
	}
	
	public LinkedList[] getAdjList(){
		return adj;
	}
}	

class Edge{
	public int start;
	public int end;
	public int weight;
	public Edge(int source, int dest, int w) {
		this.start = source;
		this.end = dest;
		this.weight = w;
	}
}

class EdgeComparator implements Comparator<Edge>{ 

	@Override
	public int compare(Edge o1, Edge o2) {
		if (o1.weight < o2.weight) 
            return -1; 
        else if (o1.weight > o2.weight) 
            return 1; 
        return 0; 
	} 
} 


//https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/tutorial/
public class MinimumSpanningTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);     
       
        GraphMST g = new GraphMST(V+1);
        
        for(int i = 0; i < E; i++) {
        	String[] edgeDetail = scanner.nextLine().split(" ");
        	int s = Integer.parseInt(edgeDetail[0]);
        	int e = Integer.parseInt(edgeDetail[1]);
        	int w = Integer.parseInt(edgeDetail[2]);
        	
        	//add edge in both direction as its undirected graph
        	Edge edge1 = new Edge(s,e,w);
        	g.addEdge(s,edge1);
        	Edge edge2 = new Edge(e,s,w);
        	g.addEdge(e,edge2);
        }
        System.out.println(prim(g, V));
	}
	
	public static int prim(GraphMST g, int V) {
		 PriorityQueue<Edge> pQueue = 
                new PriorityQueue<Edge>(V, new EdgeComparator());
		 boolean[] visited = new boolean[V+1];
		 
		 int minimumCost = 0;
		 
		 //add start point for minimum Spanning tree in queue
		 Edge zero = new Edge(0,1,0);
		 pQueue.add(zero);
		 
		 //get list of vertexes and its corrsponding mapping
		 LinkedList[] adj = g.getAdjList();
		 int y;
		 
		 while(!pQueue.isEmpty()) {
			 Edge temp = pQueue.poll();
			 
			 // Checking for cycle
		     if(visited[temp.end] == true)
		    	 continue;
		     minimumCost += temp.weight;
		     visited[temp.end] = true;
		     LinkedList<Edge>  adjList = adj[temp.end];
		     for(Edge edge : adjList)
		     {
	            if(visited[edge.end] == false)
	            	pQueue.add(edge);
		     }
		 }
		 return minimumCost;
	}
}
