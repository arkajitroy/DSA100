import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    // Global variables to keep track of mode and its count
    private static int currentVal;
    private static int currentCount;
    private static int maxCount;
    private static List<Integer> modes = new ArrayList<>();

    public static int[] findMode(TreeNode root) {
        inorderTraversal(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private static void inorderTraversal(TreeNode node) {
        if (node == null) return;

        // Recursively traverse the left subtree
        inorderTraversal(node.left);

        // Process the current node
        if (node.val == currentVal) {
            currentCount++;
        } else {
            currentVal = node.val;
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(currentVal);
        } else if (currentCount == maxCount) {
            modes.add(currentVal);
        }

        // Recursively traverse the right subtree
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] result = findMode(root);
        for (int mode : result) {
            System.out.print(mode + " ");
        }
    }
}
