class Solution {

    public static int[] twoSum_Binary(int[] numbers, int target) {
        int n = numbers.length;
        
        for (int i = 0; i < n; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, complement, i + 1, n - 1);
            
            if (index != -1) {
                // Indices in the problem statement are 1-based, so add 1 to convert to 1-based indexing
                return new int[]{i + 1, index + 1};
            }
        }
        
        // Return an empty array if no solution is found (this should not happen in this problem)
        return new int[0];
    }
    
    // Helper function to perform binary search for a complement
    private static int binarySearch(int[] numbers, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Complement not found
    }

    public static int[] twoSumII_two_pointer(int numbers[], int target){
        int left = 0, right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];
            
            if(sum == target) return new int[]{left + 1, right + 1};
            else if (sum < target) left++;
            else right--;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = twoSum_Binary(numbers, target);
        
        if (result.length == 2) {
            System.out.println("Target is " +target+" result is " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}
