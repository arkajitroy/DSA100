class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sTree = serialize(s);
        String tTree = serialize(t);
        
        return sTree.contains(tTree);
    }
    
    private String serialize(TreeNode node) {
        if (node == null) {
            return "null";
        }
        
        String left = serialize(node.left);
        String right = serialize(node.right);
        
        return "#" + node.val + left + right;
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();

        // Create the main tree
        TreeNode mainTree = new TreeNode(3);
        mainTree.left = new TreeNode(4);
        mainTree.right = new TreeNode(5);
        mainTree.left.left = new TreeNode(1);
        mainTree.left.right = new TreeNode(2);
        
        // Create the second tree
        TreeNode subTree = new TreeNode(4);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);
        
        boolean isSubtree = solution.isSubtree(mainTree, subTree);
        System.out.println("Is the second tree a subtree of the main tree? " + isSubtree);
    }
}
