package GRAPHS;

// ===============================================
// 🔹 Topological Sorting using DFS + Stack
// ===============================================
// Time Complexity: O(V + E)
// Space Complexity: O(V)
// Works only on Directed Acyclic Graph (DAG)
// ===============================================

import java.util.*;

public class TopologicalSort {

    // ---------- Edge Class ----------
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // ---------- Graph Creation ----------
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed Edges
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // ---------- DFS Utility for Topo Sort ----------
    public static void topoSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topoSortUtil(graph, e.dest, vis, stack);
            }
        }

        // After visiting all neighbors → push current node in stack
        stack.push(curr);
    }

    // ---------- Topological Sort Function ----------
    public static void topoSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topoSortUtil(graph, i, vis, stack);
            }
        }

        // Print result (Topological Order)
        System.out.print("Topological Sort Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // ---------- Main Function ----------
    public static void main(String[] args) {
        int V = 6; // Total vertices
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        topoSort(graph);
    }
}
