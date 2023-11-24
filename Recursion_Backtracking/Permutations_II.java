import java.util.*;

class Solution {

    public static List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[]nums, boolean[] used, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));   // add copy of current permutation
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;

            // Include the current element in the permutation
            used[i] = true;
            current.add(nums[i]);

            // Recursively generate permutations for the remaining elements
            backtrack(nums, used, current, result);

            // Backtrack: undo the inclusion for the next iteration
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permutations = permutation(nums);

        System.out.println("Unique Permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}