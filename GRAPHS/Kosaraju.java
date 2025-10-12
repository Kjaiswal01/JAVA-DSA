package GRAPHS;

import java.util.*;

public class Kosaraju {

    // ✅ Step 1: Edge class to represent directed edges
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ✅ Step 2: Create Directed Graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Directed graph
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    // ✅ Step 3: Topological Sort (store vertices by finish time)
    public static void topSort(ArrayList<Edge> graph[], int curr, Stack<Integer> s, boolean vis[]) {
        vis[curr] = true;
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                topSort(graph, e.dest, s, vis);
            }
        }
        s.push(curr); // push after visiting all neighbors
    }

    // ✅ Step 4: DFS for traversing graph / transpose
    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    // ✅ Step 5: Kosaraju Algorithm Implementation
    public static void kosaraju(ArrayList<Edge> graph[], int V) {
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        // Step 1: Perform Topological Sort (based on finishing time)
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort(graph, i, s, vis);
            }
        }

        // Step 2: Transpose the graph (reverse all edges)
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < V; i++) {
            vis[i] = false; // reset visited
            for (Edge e : graph[i]) {
                transpose[e.dest].add(new Edge(e.dest, e.src)); // reverse edge
            }
        }

        // Step 3: DFS using topological order on transposed graph
        System.out.println("Strongly Connected Components (SCCs):");
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC: ");
                dfs(transpose, vis, curr);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}
