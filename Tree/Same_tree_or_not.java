class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}

class Solution{

    public static boolean isSameTree(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2 == null) return true;

        if(tree1 == null || tree2 == null) return false;

        if(tree1.val != tree2.val) return false;

        return (
            isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right)
        );
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        
        // Check if the two trees are the same.
        boolean result = isSameTree(tree1, tree2);
        
        // Output the result.
        System.out.println("Are the two trees the same? " + result);
    }
}