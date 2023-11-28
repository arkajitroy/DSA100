import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution{
    // recurssive approach
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        
        // reversing the result
        Stack<List<Integer>> stack = new Stack<>();
        for(List<Integer> nodes : result){
            stack.push(nodes);
        }
        result.clear();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void dfs(TreeNode node, int depth, List<List<Integer>> result){
        if(node == null) return;

        if(result.size() <= depth) result.add(new ArrayList<>());

        // Add the current node value to the list at the current depth
        result.get(depth).add(node.val);

        // Recursively traverse the left and right subtrees
        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        
        List<List<Integer>> result = levelOrderBottom(root);

        // Printing the result
        System.out.println("Bottom-up Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}