package GRAPHS;

import java.util.*;

// Edge class to represent a connection between two vertices
class Edge {
    int src, dest;

    Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

public class BridgeInGraph {

    // DFS function for Tarjan’s algorithm
    public static void dfs(ArrayList<Edge>[] graph, int curr, int parent,
            boolean[] vis, int[] dt, int[] low, int time) {
        vis[curr] = true;

        // Initialize discovery and low time
        dt[curr] = low[curr] = ++time;

        // Explore all adjacent edges
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Ignore the edge that leads back to the parent
            if (e.dest == parent)
                continue;

            if (vis[e.dest]) {
                // If already visited → back edge found → update low value
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                // Recursive DFS for unvisited neighbor
                dfs(graph, e.dest, curr, vis, dt, low, time);

                // After recursion → update low value of current node
                low[curr] = Math.min(low[curr], low[e.dest]);

                // Bridge condition:
                // If discovery time of curr < low of child → (curr - child) is a bridge
                if (dt[curr] < low[e.dest]) {
                    System.out.println("BRIDGE : " + curr + " --- " + e.dest);
                }
            }
        }
    }

    // Main function to find all bridges
    public static void getBridge(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V]; // discovery time of each vertex
        int[] low = new int[V]; // lowest reachable discovery time
        boolean[] vis = new boolean[V];
        int time = 0;

        // Run DFS for all components (for disconnected graphs)
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time);
            }
        }
    }

    // Helper function to create graph
    public static void addEdge(ArrayList<Edge>[] graph, int src, int dest) {
        graph[src].add(new Edge(src, dest));
        graph[dest].add(new Edge(dest, src));
    }

    // Driver code
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 3, 4);

        // Find all bridges
        System.out.println("Bridges in the graph:");
        getBridge(graph, V);
    }
}
