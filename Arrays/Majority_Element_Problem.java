package Arrays;
import java.util.*;

public class Majority_Element_Problem {
    public static int bruteForce(int []arr, int n){
        for(int num : arr){
            int count = 0;
            for(int otherNum : arr){
                if(otherNum == num) count++;
            }
            if(count > n/2) return num;
        }
        return -1;
    }

    public static int better(int []arr, int n){
        Map<Integer, Integer> map = new HashMap<>();
        int majority = 0, maxFreq = 0;

        // populating the freq map, and updating the counts of each element
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                majority = entry.getKey();
            }
        }
        return majority;
    }
    public static int optimal(int[] nums) { //
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            }
            else if (candidate == num) count++;
            else count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 3, 4, 2, 4, 4, 2, 4, 4};

        int result_brute = bruteForce(numbers, numbers.length);
        System.out.println("Majority element - Brute Force: " + result_brute);

        int result_better = better(numbers, numbers.length);
        System.out.println("Majority element - Better Approach Hashmap: " + result_better);

        int result_optimal = optimal(numbers);
        System.out.println("Majority element - Optimal Approach Hashmap: " + result_optimal);
    }
}
