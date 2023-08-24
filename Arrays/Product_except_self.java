import java.util.Arrays;

class Solution {
    public static int[] product_using_division(int []nums){
        int totalProduct = 1, zeroCount = 0;
        int []result  = new int[nums.length];

        for(int elm : nums){
            if(elm == 0) zeroCount++;
            else totalProduct *= elm;
        }

        if(zeroCount >= 2){
            Arrays.fill(result, 0);
            return result;
        }

        if(zeroCount == 1){ // if there is 1 zero
            for(int i=0; i<nums.length; i++){
                result[i] = (nums[i] == 0) ? totalProduct : 0;
            }
            return result;
        }

        for(int i=0; i<nums.length; i++){
                result[i] = totalProduct / nums[i];
        }

        return result;
    }

    public static int[] product_better(int []nums){
        int n = nums.length, leftProduct = 1, rightProduct = 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int []nums = { 1,2,3,4 };

        int []result = product_using_division(nums);
        System.out.println("Output using division (brute force)"+Arrays.toString(result));

        int []result_better = product_better(nums);
        System.out.println("Output without division (better approach)"+Arrays.toString(result_better));
    }
}