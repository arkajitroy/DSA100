import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public class MergeTwoBinaryTrees {

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0];
            TreeNode node2 = nodes[1];

            // Update value of node1
            node1.val += node2.val;

            // Enqueue left children if present
            if (node1.left != null && node2.left != null) {
                queue.add(new TreeNode[]{node1.left, node2.left});
            } else if (node2.left != null) {
                node1.left = node2.left;
            }

            // Enqueue right children if present
            if (node1.right != null && node2.right != null) {
                queue.add(new TreeNode[]{node1.right, node2.right});
            } else if (node2.right != null) {
                node1.right = node2.right;
            }
        }

        return root1;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode result = mergeTrees(root1, root2);

        // Print the result if needed
        // You can implement a tree traversal method (e.g., in-order, pre-order, post-order) to print the result
    }
}
