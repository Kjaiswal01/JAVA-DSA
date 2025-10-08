package GRAPHS;

import java.util.*;

public class DFS {

    // =============== Edge Class ===============
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // =============== Graph Creation ===============
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // =============== DFS Function ===============
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        // Base Case: if already visited, return
        if (visited[curr]) {
            return;
        }

        // Print current vertex
        System.out.print(curr + " ");

        // Mark as visited
        visited[curr] = true;

        // Visit all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            dfs(graph, e.dest, visited);
        }
    }

    // =============== Main Function ===============
    public static void main(String args[]) {
        /*
         * Graph structure:
         * 1 --- 3
         * / | / \
         * 0 | 5---6
         * \ | /
         * 2---4
         */

        int V = 7; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        System.out.println("DFS Traversal starting from node 0:");
        dfs(graph, 0, new boolean[V]);
    }
}
