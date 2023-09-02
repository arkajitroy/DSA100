package Graphs;
import java.util.*;


class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Function to perform BFS starting from a given vertex
    public void BFS(int startVertex) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, mark it
            // as visited and enqueue it
            for (Integer neighbor : adj[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create a graph with 7 vertices
        Graph graph = new Graph(7);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Breadth-First Traversal (starting from vertex 0):");
        graph.BFS(0);
    }
}

