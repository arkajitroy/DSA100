import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, 0, result);
        return result;
    }

    private void generatePermutations(int []nums, int index, List<List<Integer>> result){
        if(index == nums.length - 1){
            List<Integer> permut = new ArrayList<>();
            for(int num : nums){
                permut.add(num);
            }
            result.add(permut);
            return;
        }

        for(int i= index; i<nums.length; i++){
            swap(nums, index, i);
            generatePermutations(nums, index + 1, result);
            swap(nums, index, i); // backtrack
        }
    }

    private void swap(int []nums, int prev, int next){
        int temp = nums[prev];
        nums[prev] = nums[next];
        nums[next] = temp;
    }


    public static void main(String[] args) {
        Solution res = new Solution();

        int []nums = { 1, 2, 3};

        List<List<Integer>> permutation_results = res.permutation(nums);
        for(List<Integer> iterator : permutation_results){
            System.out.println(iterator);
        }
    }
}
