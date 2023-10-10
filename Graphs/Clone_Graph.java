import java.util.*;

class Node{
    public int val;
    public List<Node> neighbours;

    public Node(){
        val = 0;
        neighbours = new ArrayList<>();
    }

    public Node(int val){
        this.val = val;
        neighbours = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbours){
        this.val = val;
        this.neighbours = neighbours;
    }
}

class Solution{

    public static Node cloneGraph (Node node){
        if(node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        return cloneDFS(node, visited);
    }

    private static Node cloneDFS(Node node, Map<Node, Node> visited){
        if(visited.containsKey(node)) return visited.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        for(Node neighbour : node.neighbours){
            cloneNode.neighbours.add(cloneDFS(neighbour, visited));
        }

        return cloneNode;
    }

    private static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) return;

        visited.add(node);

        System.out.print("Node " + node.val + " (neighbors: ");
        for (Node neighbor : node.neighbours) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println(")");

        for (Node neighbor : node.neighbours) {
            printGraph(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbours.add(node2);
        node1.neighbours.add(node4);
        node2.neighbours.add(node1);
        node2.neighbours.add(node3);
        node3.neighbours.add(node2);
        node3.neighbours.add(node4);
        node4.neighbours.add(node1);
        node4.neighbours.add(node3);

        Solution solution = new Solution();
        Node clonedNode = cloneGraph(node1);

        // Now you can work with the cloned graph as needed.
        // For example, you can traverse the cloned graph and print its structure.
        System.out.println("Original Graph:");
        printGraph(node1, new HashSet<>());

        System.out.println("\nCloned Graph:");
        printGraph(clonedNode, new HashSet<>());
    }
}