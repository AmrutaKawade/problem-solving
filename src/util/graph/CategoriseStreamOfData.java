package util.graph;

import java.util.LinkedList;
import java.util.ListIterator;

/*
 * You will be given a stream of data in pairs -
 * [{1,2},{2,3},{4,5},{6,7},{4,7},{3,8},{9,10},{11,4}..... ]
 * Here you have to categorize the data .. 
 * Like below -
 * [1,2,3,8]
 * [4,5,6,7,11]
 * [9,10]
 * 
 * */
public class CategoriseStreamOfData {
	public static void main(String[] args) {
		int[][] input = {{1,2},{2,3},{4,5},{6,7},{4,7},{3,8},{9,10},{11,4}};
		Graph g = createGraph(input);
		LinkedList[] list = g.getAdjList();
		boolean[] visited = new boolean[list.length];
		for(int node = 0; node < (list.length); node++){
			LinkedList set = new LinkedList();
			dfs(node,list,visited,set);
			if(set.size() > 0){
				set.add(node);
				printSet(set);
			}
		}
	}

	private static void printSet(LinkedList set) {
		ListIterator list = set.listIterator();
		while(list.hasNext()){
			System.out.print((int)list.next()+" ");
		}
		System.out.println();
	}

	private static void dfs(int node, LinkedList[] adjList, boolean[] visited, LinkedList set) {
		visited[node] = true;
		ListIterator list = adjList[node].listIterator();
		while(list.hasNext()){
			int n = (int) list.next();		
			if(!visited[n]){
				set.add(n);
				dfs(n,adjList,visited,set);
			}
		}
	}

	private static Graph createGraph(int[][] input) {
		Graph g = new Graph(input.length*2);
		for(int i = 0; i < input.length; i++){
			int[] tuple = input[i];
			g.addEdge(tuple[0], tuple[1]);
			g.addEdge(tuple[1], tuple[0]);
		}
		return g;
	}
}
