package GRAPHS;

import java.util.*;

// Program to Print All Paths between Source and Target using DFS
public class PrintAllPaths {

    // Edge class to represent connections between vertices
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Function to create graph using adjacency list
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Define edges (Undirected graph)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // Recursive DFS function to print all paths from src → tar
    public static void printAllPaths(ArrayList<Edge> graph[], int src, int tar, String path, boolean vis[]) {
        // Base case: if destination reached
        if (src == tar) {
            System.out.println(path);
            return;
        }

        // Explore all neighbours
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest]) { // if destination node not visited
                vis[e.dest] = true;
                printAllPaths(graph, e.dest, tar, path + " -> " + e.dest, vis);
                vis[e.dest] = false; // backtrack
            }
        }
    }

    // Main function
    public static void main(String args[]) {
        int V = 7; // Number of vertices
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0; // Source vertex
        int tar = 5; // Target vertex

        boolean vis[] = new boolean[V];
        vis[src] = true; // Mark source as visited

        System.out.println("All Paths from " + src + " to " + tar + ":");
        printAllPaths(graph, src, tar, "" + src, vis);
    }
}
