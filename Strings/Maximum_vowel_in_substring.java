import java.util.HashSet;
import java.util.Set;

class Maximum_vowel_in_substring {

    public static int maxVowel(String s, int k){
        int maxVowels = 0;
        int windowVowels = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i');
        vowels.add('o'); vowels.add('u');

        // Count the number of vowels in the first window
        for (int i = 0; i < k; i++)
        if (vowels.contains(s.charAt(i)))
            windowVowels++;

        maxVowels = windowVowels;

        // Slide the window and update the maximum number of vowels
        for (int i = k; i < s.length(); i++) {
        if (vowels.contains(s.charAt(i - k)))
            windowVowels--;

        if (vowels.contains(s.charAt(i)))
            windowVowels++;

        maxVowels = Math.max(maxVowels, windowVowels);
        }

        return maxVowels;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;

        int Solution = maxVowel(s, k);
    }    
}
