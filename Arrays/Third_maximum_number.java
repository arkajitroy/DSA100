import java.util.HashSet;
import java.util.Set;

class Solution {

    public static int thirdMax(int nums[]){
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num < first && num > second) {
                third = second;
                second = num;
            } else if (num < second && num > third) {
                third = num;
            }
        }
        return (third == Long.MIN_VALUE) ? (int) first : (int) third;
    }
    public static void main(String[] args) {
         int[] nums = {3, 2, 1};
         int result = thirdMax(nums);
    
        System.out.println("The third maximum number is: " + result);
        
    }
}