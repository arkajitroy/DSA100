class Solution {
    public static int findMin_LinearSearch(int[] nums) {
        int min = nums[0];     
        for (int num : nums) {
            if (num < min) min = num;
        }  
        return min;
    }

    public static int findMin_BinarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;    
            else right = mid;
        }
        return nums[left];
    }
    
    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 8, 1, 2, 3};
        int min = findMin_BinarySearch(rotatedArray);
        System.out.println("Minimum element: " + min);
    }
}
