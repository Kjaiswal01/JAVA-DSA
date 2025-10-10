package GRAPHS;

// ===============================================
// 🔹 Dijkstra’s Algorithm - Shortest Path
// ===============================================
// Time Complexity: O((V + E) * logV)
// Space Complexity: O(V)
// Works only on graphs with NON-NEGATIVE weights
// ===============================================

import java.util.*;

public class Dijkstras {

    // ---------- Edge Class ----------
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

    // ---------- Create Graph ----------
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed weighted edges
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // ---------- Pair Class (for PriorityQueue) ----------
    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // Sort by path distance
        }
    }

    // ---------- Dijkstra Function ----------
    public static int[] dijkstra(ArrayList<Edge>[] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[graph.length];
        boolean[] vis = new boolean[graph.length];

        // Initially set all distances to infinity
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (Edge e : graph[curr.node]) {
                    int u = e.src;
                    int v = e.dest;

                    if (!vis[v] && dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        return dist;
    }

    // ---------- Main Function ----------
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        int[] dist = dijkstra(graph, src);

        System.out.println("Shortest Distances from Source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Vertex " + i + " → Distance = " + dist[i]);
        }
    }
}
