class Solution{

    public static int splitArray_BS(int nums[], int k){
        long left = 0, right = 0;

        for(int num : nums){
            left = Math.max(left, num);
            right = right + num;
        }

        while(left < right){
            long mid = left + (right - left) / 2;
            if(isValid(nums, k, mid)) right = mid;
            else left = mid + 1;
        }
        return (int) left;
    }

    private static boolean isValid(int nums[], int k, long maxSum){
        int count = 1;
        long currentSum = 0;

        for(int num : nums){
            currentSum += num;
            if(currentSum > maxSum){
                count++;
                currentSum = num;
                if(count > k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result_BS = splitArray_BS(nums, k);
        System.out.println("Minimum Largest Sum: " + result_BS);
    }
}