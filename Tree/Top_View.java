import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    private static class NodeInfo {
        TreeNode node;
        int horizontalDistance;

        public NodeInfo(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public static void topView(TreeNode root) {
        if (root == null) return;

        // Create a HashMap to store the top view elements by horizontal distance
        HashMap<Integer, Integer> topViewMap = new HashMap<>();

        // Create a queue for level-order traversal
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(root, 0));

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            int horizontalDistance = current.horizontalDistance;
            TreeNode node = current.node;

            // If the horizontal distance is not in the map, add it to the map
            if (!topViewMap.containsKey(horizontalDistance)) {
                topViewMap.put(horizontalDistance, node.data);
            }

            // Enqueue left child with a decreased horizontal distance
            if (node.left != null) {
                queue.add(new NodeInfo(node.left, horizontalDistance - 1));
            }

            // Enqueue right child with an increased horizontal distance
            if (node.right != null) {
                queue.add(new NodeInfo(node.right, horizontalDistance + 1));
            }
        }

        // Print the top view elements in order of horizontal distance
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        System.out.println("Top View of Binary Tree:");
        topView(root);
    }
}
