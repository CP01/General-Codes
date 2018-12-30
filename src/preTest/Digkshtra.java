package preTest;
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Digkshtra {
	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0)
		{
			String str = br.readLine();
			String nm[] = str.split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int graph[][] = new int[n][n];
			while(m-->0)
			{
				str = br.readLine();
				nm = str.split(" ");
				int x,y,c;
				x =  Integer.parseInt(nm[0]);
				y = Integer.parseInt(nm[1]);
				c = Integer.parseInt(nm[2]);
				x--;y--;
				if(graph[x][y]==0 || graph[x][y]>c) {
					graph[x][y] = c;
					graph[y][x] = c;
				}
			}
			str = br.readLine();
			nm = str.split(" ");
			int s,a,h;
			s =  Integer.parseInt(nm[0]);
			a = Integer.parseInt(nm[1]);
			h = Integer.parseInt(nm[2]);
			s--;a--;h--;
			ShortestPath t = new ShortestPath(n);
			int result = 0;
			result+=t.dijkstra(graph, s, a,h);
			result = result + 2*t.dijkstra(graph, a , s,h);
			result+=t.dijkstra(graph, h , s, a);
			System.out.println(result);
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(graph[i][j]+" ");
				}
				System.out.println();
			}

		}

	}
}


class ShortestPath 
{ 
	// A utility function to find the vertex with minimum distance value, 
	// from the set of vertices not yet included in shortest path tree 
	static int V;
	int sum = 0;
	ShortestPath(int size)
	{
		V = size;
	} 
	int minDistance(int dist[], Boolean sptSet[]) 
	{ 
		// Initialize min value 
		int min = Integer.MAX_VALUE, min_index=-1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= min) 
			{ 
				min = dist[v]; 
				min_index = v; 
			} 

		return min_index; 
	} 

	// A utility function to print the constructed distance array 
	void printSolution(int dist[], int n) 
	{ 
		// System.out.println("Vertex   Distance from Source"); 
		for (int i = 0; i < V; i++) 
			System.out.println(i+" tt "+dist[i]); 
		//sum = sum + dist[i];
	} 

	// Funtion that implements Dijkstra's single source shortest path 
	// algorithm for a graph represented using adjacency matrix 
	// representation 
	int dijkstra(int graph[][], int src, int a1, int a2) 
	{ 
		int dist[] = new int[V]; // The output array. dist[i] will hold 
		// the shortest distance from src to i 

		// sptSet[i] will true if vertex i is included in shortest 
		// path tree or shortest distance from src to i is finalized 
		Boolean sptSet[] = new Boolean[V]; 

		// Initialize all distances as INFINITE and stpSet[] as false 
		for (int i = 0; i < V; i++) 
		{ 
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		// Distance of source vertex from itself is always 0 
		dist[src] = 0; 

		// Find shortest path for all vertices 
		for (int count = 0; count < V-1; count++) 
		{ 
			// Pick the minimum distance vertex from the set of vertices 
			// not yet processed. u is always equal to src in first 
			// iteration. 
			int u = minDistance(dist, sptSet); 

			// Mark the picked vertex as processed 
			sptSet[u] = true; 

			// Update dist value of the adjacent vertices of the 
			// picked vertex. 
			for (int v = 0; v < V; v++) 

				// Update dist[v] only if is not in sptSet, there is an 
				// edge from u to v, and total weight of path from src to 
				// v through u is smaller than current value of dist[v] 
				if (!sptSet[v] && graph[u][v]!=0 && 
				dist[u] != Integer.MAX_VALUE && 
				dist[u]+graph[u][v] < dist[v]) 
					dist[v] = dist[u] + graph[u][v]; 
		} 

		// print the constructed distance array 
		// printSolution(dist, V ); 
		for (int i = 0; i < V; i++) {
			//System.out.println(i+" tt "+dist[i]); 
			if(i!=a1 && i!=a2 && sum<dist[i]) {
				sum = dist[i];
			}
		}
		int res = sum;
		sum = 0;
		return res;
	} 
}
