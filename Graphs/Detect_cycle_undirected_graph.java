import java.util.*;

class Solution {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        // Create an array to keep track of visited nodes
        boolean[] visited = new boolean[A + 1];

        // Create an adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }

        // Fill the adjacency list based on the input edges
        for (ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Perform DFS to detect cycles
        for (int i = 1; i <= A; i++) {
            if (!visited[i] && hasCycleDFS(i, -1, visited, adjList)) {
                return 1; // If a cycle is found, return 1
            }
        }

        return 0; // If no cycle is found, return 0
    }

    private boolean hasCycleDFS(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;

        // Visit all adjacent nodes
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                // If the neighbor is not visited, continue DFS
                if (hasCycleDFS(neighbor, node, visited, adjList)) {
                    return true; // Cycle found in the subtree
                }
            } else if (neighbor != parent) {
                return true; // Neighbor is visited and not the parent, indicating a cycle
            }
        }

        return false; // No cycle found in the subtree
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int A = 5; // Number of nodes
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(1, 2)));
        B.add(new ArrayList<>(List.of(2, 3)));
        B.add(new ArrayList<>(List.of(3, 4)));
        B.add(new ArrayList<>(List.of(4, 5)));
        B.add(new ArrayList<>(List.of(5, 2))); // Creating a cycle

        int result = solution.solve(A, B);

        if (result == 1) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
