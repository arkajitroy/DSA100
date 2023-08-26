class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public static class Pair {
        Integer floor;
        Integer ceil;

        Pair(Integer floor, Integer ceil) {
            this.floor = floor;
            this.ceil = ceil;
        }
    }

    public static Pair findFloorCeil(TreeNode root, int key){
        Pair result = new Pair(null, null);

        while(root != null){
            if(root.val == key){
                result.floor = root.val;
                result.ceil = root.val;
                break;
            }else if(root.val < key){
                result.floor= root.val;
                root = root.right;
            }else{
                result.ceil= root.val;
                root = root.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        int key = 5; // Key to find floor and ceil for

        Pair result = findFloorCeil(root, key);

        System.out.println("Floor: " + (result.floor != null ? result.floor : "N/A"));
        System.out.println("Ceil: " + (result.ceil != null ? result.ceil : "N/A"));
        
    }
}