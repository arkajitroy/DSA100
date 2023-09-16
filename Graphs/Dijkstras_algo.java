import java.util.*;

class Solution {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[S] = 0;
        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(S, 0));
        
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.vertex;
            
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0); // The neighbor vertex
                int w = neighbor.get(1); // The weight of the edge
                
                int newDistance = distance[u] + w;
                if (newDistance < distance[v]) {
                    distance[v] = newDistance;
                    minHeap.offer(new Node(v, newDistance));
                }
            }
        }
        
        return distance;
    }

    public static void main(String[] args) {
        int V = 5;
        int S = 0; // Source vertex
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges and weights to the graph.
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(4, 2)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 5)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 3)));
        
        int[] shortestDistances = dijkstra(V, adj, S);
        
        // Print the shortest distances from the source vertex to all other vertices.
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from " + S + " to " + i + ": " + shortestDistances[i]);
        }
    }
    
    static class Node {
        int vertex;
        int weight;
        
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
