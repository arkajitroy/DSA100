import java.util.*;

class Largest_Number {

    public static String largestNumber(int[] nums){
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = Integer.toString(nums[i]);
        }

        // Define a custom comparison function
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Reverse order to get the largest number
            }
        };

        // Sort the strings using the custom comparison function
        Arrays.sort(numStrs, customComparator);

        // Concatenate and remove leading zeros
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };
        String result = largestNumber(nums);

        System.out.println("Array -> "+Arrays.toString(nums)+"\n Largest Number"+result);
    }    
}
