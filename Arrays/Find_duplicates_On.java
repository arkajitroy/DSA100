class Solution {
    public static int findDuplicate(int nums[]){
        int slow = nums[0] , fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2}; // Example array with a duplicate
        int duplicate = findDuplicate(nums);
        System.out.println("Duplicate element: " + duplicate);
    }
}
