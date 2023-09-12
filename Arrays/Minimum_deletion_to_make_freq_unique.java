import java.util.Arrays;

class Solution {

    public static int minDeletions(String s){
        int[] freq = new int[26];
        int result = 0;
        
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq);
        
        
        
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0) break;
            
            if (freq[i] >= freq[i + 1]) {
                int prev = freq[i];
                freq[i] = Math.max(0, freq[i + 1] - 1);
                result += prev - freq[i]; // Update the resultetion count
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String input = "aaabbccc";
        int minDeletions = minDeletions(input);
        System.out.println("Given Array => "+input+"\nMinimum deletions required: " + minDeletions);
    }
    
}
