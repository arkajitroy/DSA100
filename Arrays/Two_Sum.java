import java.util.Arrays;
import java.util.HashMap;


class Main {
    // Brute Force Approach - O(n^2)
    public static int[] twoSum_Brute(int[] nums, int target){
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int currentSum = nums[i] + nums[j];
                if( currentSum == target ) return new int[]{i,j};
            }
        }
        return new int[]{}; // returning blank array
    }

    // Better Approach - O(n) | O(n)
    public static int[] twoSumMap(int[] nums, int target){
        // map<digits, index>
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int remainingAmount = target - nums[i];
            if(map.containsKey(remainingAmount)) return new int[]{map.get(remainingAmount),i};

            // if not found put the element in the map
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    // Optimal Approach - O(n) | O(1)
    public static int[] twoSum(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left < right) {
            int num1 = nums[left], num2 = nums[right];
            int sum = num1 + num2;

            // checking
            if (sum == target) return new int[]{left, right};
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
    }    
}
