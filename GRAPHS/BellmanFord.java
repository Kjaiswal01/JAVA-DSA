package GRAPHS;

import java.util.*;

public class BellmanFord {

    // ✅ Edge class represents a directed weighted edge (u → v with weight wt)
    static class Edge {
        int src; // source vertex
        int dest; // destination vertex
        int wt; // weight of the edge

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // ✅ Function to create a sample graph
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed weighted edges
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    // ✅ Bellman-Ford Algorithm
    public static void bellmanFord(ArrayList<Edge> graph[], int src) {

        int dist[] = new int[graph.length]; // distance array to store shortest distance from src

        // Initialize all distances as infinity (MAX_VALUE)
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // 🔹 Step 1: Relax all edges (V-1) times
        // Because shortest paths can have at most (V-1) edges
        for (int i = 0; i < graph.length - 1; i++) {
            // Check all edges
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation step: update dist[v] if shorter path found via u
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // 🔹 Step 2: Detect Negative Weight Cycle
        // Run one more relaxation — if distance still decreases → negative cycle exists
        for (int j = 0; j < graph.length; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                Edge e = graph[j].get(k);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    System.out.println("⚠️ Negative Weight Cycle exists!");
                    return;
                }
            }
        }

        // 🔹 Step 3: Print final shortest distances
        System.out.println("Shortest distances from source " + src + " :");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        bellmanFord(graph, src);
    }
}

// 🕒 Time Complexity: O(V × E)
// 📦 Space Complexity: O(V)