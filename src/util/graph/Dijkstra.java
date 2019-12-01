package util.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;



class DistanceComparator implements Comparator<Edge>{ 

	@Override
	public int compare(Edge o1, Edge o2) {
		if (o1.distance < o2.distance) 
            return -1; 
        else if (o1.distance > o2.distance) 
            return 1; 
        return 0; 
	} 
} 

public class Dijkstra {
	
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
        	
        	//add edge in both direction if its undirected graph
        	Edge edge = new Edge(e,w);
        	g.addEdge(s,edge);
        }
        
        int[] allDistances = dijkstra(g, V);
        for(int i = 2; i <= V; i++) {
        	if(allDistances[i] == Integer.MAX_VALUE) {
        		System.out.print((Math.pow(10,9)) + " ");
        	}else {
        		System.out.print(allDistances[i] + " ");
        	}
        }
	}
	
	public static int[] dijkstra(GraphMST g, int V) {
		
		 PriorityQueue<Edge> pQueue = 
                new PriorityQueue<Edge>(V, new DistanceComparator());
		 
		 boolean[] visited = new boolean[V+1];
		 
		 //save distances of each vertex from source
		 int[] dist = new int[V+1];
		 
		 //add start point for minimum Spanning tree in queue
		 //distance of source node to itself is always 0
		 Edge start = new Edge(1,0);
		 pQueue.add(start);
		 start.distance = 0;
		 dist[1] = 0;
		 
		 //get list of vertexes and its corrsponding mapping
		 LinkedList[] adj = g.getAdjList();
		 
		 while(!pQueue.isEmpty()) {
			 Edge temp = pQueue.poll();
			 
			 // Checking for cycle
		     if(visited[temp.vertex] == true)
		    	 continue;
		     
		     visited[temp.vertex] = true;
		     
		     LinkedList<Edge> adjList = adj[temp.vertex];
		     
		     for(Edge edge : adjList)
		     {
	            if(visited[edge.vertex] == false && (temp.distance + edge.weight) < edge.distance) {
	            	edge.distance = temp.distance + edge.weight;
	            	dist[edge.vertex] = edge.distance;
	            	pQueue.add(edge);
	            }
		     }
		 }
		 return dist;
	}
}


