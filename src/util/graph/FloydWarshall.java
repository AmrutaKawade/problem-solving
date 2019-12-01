package util.graph;

import java.util.Scanner;

public class FloydWarshall {
	public static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);  
        int[][] graph = new int[V+1][V+1];
        int[][] dist = new int[V+1][V+1];
        
        //fill the matrix with MAXVAlue
        for(int i = 0; i < V+1; i++) {
        	for(int j = 0; j < V+1; j++) {
        		if(i == j) {
        			graph[i][j] = 0;
                	dist[i][j] = 0;
        		}else {
        			graph[i][j] = INF;
                	dist[i][j] = INF;
        		}
            }
        }
       
        //update the matrix with actual distances
        for(int i = 0; i < E; i++) {
        	String[] edgeDetail = scanner.nextLine().split(" ");
        	int s = Integer.parseInt(edgeDetail[0]);
        	int e = Integer.parseInt(edgeDetail[1]);
        	int w = Integer.parseInt(edgeDetail[2]);
        	
        	graph[s][e] = w;
        	dist[s][e] = w;
        }
        
        int[][] ans = floydWarshall(dist,V);
        for(int i = 2; i < V+1; i++) {
        	if(dist[1][i] == Integer.MAX_VALUE) {
        		System.out.print((Math.pow(10,9)) + " ");
        	}else {
        		System.out.print(dist[1][i] + " ");
        	}
        }
	}
	
	public static int[][] floydWarshall(int[][] dist, int V){
		for (int k = 1; k < V+1; k++) 
        { 
            // Pick all vertices as source one by one 
            for (int i = 1; i < V+1; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (int j = i+1; j < V+1; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                	if(dist[i][k] != INF && dist[k][j] != INF)
                		dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); 
                } 
            } 
        } 
		return dist;
	}
}
