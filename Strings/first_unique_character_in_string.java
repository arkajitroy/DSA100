import java.util.HashMap;
import java.util.Map;

class Main {
    public static char firstUniqueCharacter(String str){
        if (str == null || str.length() == 0) return ' ';

        char result = ' ';
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int frequency = freqMap.getOrDefault(ch, 0);
            // updating the map
            freqMap.put(ch, frequency + 1);
        }

        // iterating the map
        for (char character : str.toCharArray()) {
            if (freqMap.get(character) == 1) {
                result = character;
                break; // no need to continue once the first unique character is found
            }
        }
        return result;
    }

    // FREQUENCY ARRAY COUNTER: O(n) | O(1)
    public static int firstUniqChar(String s) {
        int[] frequencyArray = new int[26];
        
        for (char ch : s.toCharArray()) {
            frequencyArray[ch - 'a']++;
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequencyArray[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1; // No unique character found
    }

    public static void main(String[] args) {
        String input = "leetcode";
        char result = firstUniqueCharacter(input);
        int result2 = firstUniqChar(input);
        System.out.println("First unique character characters :"+result);
        System.out.println("Unique Character :"+ input.charAt(result2));
    }
}
