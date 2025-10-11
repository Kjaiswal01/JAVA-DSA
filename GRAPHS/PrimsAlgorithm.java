package GRAPHS;

import java.util.*;

public class PrimsAlgorithm {

    // ✅ Edge class (undirected weighted edge)
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

    // ✅ Create sample graph
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected weighted graph
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    // ✅ Pair class to represent (vertex, weight)
    static class Pair implements Comparable<Pair> {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        // Compare based on weight (for min-heap)
        @Override
        public int compareTo(Pair p2) {
            return this.wt - p2.wt;
        }
    }

    // ✅ Prim’s Algorithm Implementation
    public static void primAlgo(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length]; // visited array
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // min-heap based on weight

        pq.add(new Pair(0, 0)); // start from vertex 0 with cost 0
        int cost = 0; // store total MST cost

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.v]) { // if not yet visited
                vis[curr.v] = true;
                cost += curr.wt; // add edge weight to MST cost

                // explore all neighbours of current vertex
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.dest]) { // add only unvisited vertices to PQ
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println(" Minimum Cost of MST: " + cost);
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        primAlgo(graph);
    }
}

// 🕒 Time Complexity: O(E log V)
// 📦 Space Complexity: O(V + E)