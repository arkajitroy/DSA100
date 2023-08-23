import java.util.Arrays;
import java.util.Comparator;

class Solution{

    // Greedy Approach: O(n log n)
    public static String greedy(int arr[]){
        String arrString[] = new String[arr.length];
        for(int i=0; i<arr.length; i++){
            arrString[i] = Integer.toString(arr[i]);
        }

        Arrays.sort(arrString, (s1, s2) -> {
            String combination1 = s1 + s2;
            String combination2 = s2 + s1;
            return combination2.compareTo(combination1); 
        });

        if(arrString[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();

        for(String str : arrString){
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String result = greedy(nums);
        System.out.println("The largest number is: " + result);
    }
}