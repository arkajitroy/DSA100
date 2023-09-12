import java.util.HashMap;
import java.util.HashSet;

class Solution {

    public int lengthOfLongestSubstring_BRUTE(String s) {
        int n = s.length();
        int maxLength = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        
        return maxLength;
    }
    
    private boolean allUnique(String s, int start, int end) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }

    // Sliding Window - HashMap / HashSet
    public int lengthOfLongestSubstring(String s) {
         HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0, n = s.length(), len = 0;
        
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "abcabcbb";
        int longestLength = solution.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + longestLength);
    }
}