import java.util.Arrays;

class Solution{

    public static int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);

         int closestSum = Integer.MAX_VALUE, minDiff = Integer.MIN_VALUE;

         for(int i=0; i<nums.length-2; i++){
            int left = i+1, right = nums.length-1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];
                int currDiff = Math.abs(currSum - target);

                //updating the closes sum
                if(currDiff < minDiff){
                    minDiff = currDiff;
                    closestSum = currSum;
                }

                //adjusting the pointers
                if(currSum<target) left++;
                else right--;
            }
         }
         return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest(nums, target);

        System.out.println("The closest 3Sum to the target is: " + result);
    }
}