import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution{

    // Nested Loop Approach - O(n^3)
    public static List<List<Integer>> brute(int []nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            for(int j = i+1; j<n-1; j++){
                for(int k= j+1; k<n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i] , nums[j] , nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }

    public static List<List<Integer>> better_HASH(int []nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            int target = - nums[i];
            Map<Integer, Integer> map = new HashMap<>();

            for(int j=i+1; j<n; j++){
                int complement = target - nums[j]; // third_element = - ( arr[i] - arr[j])

                if(map.containsKey(complement)){
                    result.add(Arrays.asList(nums[i], nums[j], complement));
                    while(j+1 < n && nums[j] == nums[j+1]){
                        j++;
                    }
                }
                map.put(nums[j], j);
            }
        }

        return result;
    }

    public static void printSolution(List<List<Integer>> result){
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        
        System.out.println("Brute Force approach");
        List<List<Integer>> result_brute = brute(nums);
        printSolution(result_brute);

        System.out.println("Better Approach");
        List<List<Integer>> result_better = brute(nums);
        printSolution(result_better);
        
    }
}