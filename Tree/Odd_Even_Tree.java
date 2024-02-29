
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main{
    public static boolean isEvenOddTree(TreeNode root){
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level=0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                int val = node.val;

                if(level % 2 == 0 && ( val % 2 == 0 || val <= prev) || level % 2 != 0 && ( val % 2 != 0 || val >= prev)) return false;

                prev = val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println("Is this a Even-Odd Tree"+isEvenOddTree(root));
    }
}