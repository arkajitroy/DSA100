import java.util.ArrayList;
import java.util.List;

class Majority_Elements_II {

    public static List<Integer> majorityElement (int[] nums){
        List <Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0) return result;

        int candidate = 0, candidate2 = 0, count1 = 0, count2 = 0;

        for(int num : nums){
            if(num == candidate) count1++;
            else if(num == candidate2) count2++;
            else if(count1 == 0){
                candidate = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0; 
        count2 = 0;

        for(int num : nums){
            if(num == candidate) count1++;
            else if(num == candidate2) count2++;
        }

        // check if candidates are majority elements
        if(count1 > nums.length / 3) result.add(candidate);
        if(count2 > nums.length / 3) result.add(candidate2);

        return result;
        
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> majorityElements = majorityElement(nums);
        System.out.println("Majority Elements: " + majorityElements);
    }
    
}
