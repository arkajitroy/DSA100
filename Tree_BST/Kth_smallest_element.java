class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    private static int count = 0;
    private static int result = 0;

    public static int kthSmallest(TreeNode root, int k){
        inorderTraversal(root, k);
        return result;
    }

    private static void inorderTraversal(TreeNode root, int k){
        if(root == null || count >= k) return;

        inorderTraversal(root.left, k);
        count++;
        if(count == k){
            result = root.val;
            return;
        }
        inorderTraversal(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.right = new TreeNode(2);

        int k = 2;

        int recurssiveResult = kthSmallest(tree, k);
        System.out.println("The Kth smallest element is : "+recurssiveResult+" (k value is "+k+")");
    }
}