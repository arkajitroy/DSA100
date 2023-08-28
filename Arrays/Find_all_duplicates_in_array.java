import java.util.ArrayList;
import java.util.List;

class Solution {

    public static List<Integer> cyclicSort(int nums[]){
        List<Integer> duplicates = new ArrayList<>();
        int i=0;

        while(i < nums.length){
            if(nums[i] != i+1 && )
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 1, 9, 3}; // Example array with duplicates
        
        List<Integer> result_cyclicSort = cyclicSort(nums);
        System.out.println("Duplicates: " + result_cyclicSort);
    }
    
}
