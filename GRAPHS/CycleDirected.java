package GRAPHS;

// =======================================
// CYCLE DETECTION IN DIRECTED GRAPH
// =======================================

import java.util.*;

public class CycleDirected {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Graph Example 1 (contains a cycle)
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    /*
     * // Graph Example 2 (no cycle)
     * static void createGraph(ArrayList<Edge> graph[]) {
     * for (int i = 0; i < graph.length; i++) {
     * graph[i] = new ArrayList<>();
     * }
     * 
     * graph[0].add(new Edge(0, 1));
     * graph[0].add(new Edge(0, 2));
     * graph[1].add(new Edge(1, 3));
     * graph[2].add(new Edge(2, 3));
     * }
     */

    // Helper Function: DFS for cycle detection
    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) { // cycle found
                return true;
            }

            if (!vis[e.dest]) {
                if (isCyclicUtil(graph, e.dest, vis, stack)) {
                    return true;
                }
            }
        }

        stack[curr] = false; // remove from recursion stack
        return false;
    }

    // Main Function for detecting cycle
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, i, vis, new boolean[vis.length])) {
                    return true;
                }
            }
        }
        return false;
    }

    // MAIN FUNCTION
    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Cycle exists in Directed Graph: " + isCyclic(graph));
    }
}
