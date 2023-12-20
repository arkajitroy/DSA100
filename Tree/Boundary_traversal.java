import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class Main {
    public static ArrayList <Integer> boundaryTraversal(Node root){
	    ArrayList<Integer> result = new ArrayList<>();

        if (root != null) {
            result.add(root.data);
            leftBoundary(root.left, result);
            leaves(root.left, result);
            leaves(root.right, result);
            rightBoundary(root.right, result);
        }

        return result;
	}
	
	public static void leftBoundary(Node node, ArrayList<Integer> result){
	    if (node != null) {
            if (node.left != null) {
                result.add(node.data);
                leftBoundary(node.left, result);
            } else if (node.right != null) {
                result.add(node.data);
                leftBoundary(node.right, result);
            }
        }
	}
	
	public static void rightBoundary(Node node, ArrayList<Integer> result){
	    if (node != null) {
            if (node.right != null) {
                rightBoundary(node.right, result);
                result.add(node.data);
            } else if (node.left != null) {
                rightBoundary(node.left, result);
                result.add(node.data);
            }
        }
	}
	
	public static void leaves(Node node, ArrayList<Integer> result) {
        if (node != null) {
            leaves(node.left, result);
            if (node.left == null && node.right == null) result.add(node.data);
            leaves(node.right, result);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        // Perform boundary traversal and print the result
        ArrayList<Integer> result = boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + result);
    }
}
