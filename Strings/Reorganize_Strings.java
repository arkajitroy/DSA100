import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public static String counterApproach(String s){
        int n = s.length();

        Map<Character, Integer> count = new HashMap<>();
        for(char c: s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> count.get(b) - count.get(a));
         maxHeap.addAll(count.keySet());
        char mostFrequent = maxHeap.poll();
        int maxCount = count.get(mostFrequent);
        
        // Step 3: Check if it's possible to reorganize the string
        if (maxCount > (n + 1) / 2) {
            return ""; // Impossible to reorganize
        }
        
        // Step 4: Reorganize the string
        char[] result = new char[n];
        int index = 0;
        
        // First, fill even positions with the most frequent character
        while (maxCount > 0) {
            result[index] = mostFrequent;
            index += 2;
            maxCount--;
        }
        
        // Then, fill the remaining positions with other characters
        for (char c : count.keySet()) {
            if (c != mostFrequent) {
                while (count.get(c) > 0) {
                    if (index >= n) {
                        index = 1; // Start from odd positions
                    }
                    result[index] = c;
                    index += 2;
                    count.put(c, count.get(c) - 1);
                }
            }
        }
        
        return new String(result);
    }

    public static void main(String[] args) {
        String input = "aab";
        String result = counterApproach(input);
        System.out.print("Recognized String (using map) => "+ result);
    }
}
