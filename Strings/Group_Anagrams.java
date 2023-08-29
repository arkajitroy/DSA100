import java.util.*;

class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> anagrams = new HashMap<>();

        for(String str : strs){
            char [] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            List<String> group = anagrams.getOrDefault(key, new ArrayList<>());
            group.add(str);
            anagrams.put(key, group);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static List<List<String>> groupAnagramsCounter(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            int[] charCount = new int[26];
            
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count);
                keyBuilder.append("#"); // Use a delimiter to separate counts.
            }
            String key = keyBuilder.toString();
            
            List<String> group = anagramGroups.getOrDefault(key, new ArrayList<>());
            group.add(str);
            anagramGroups.put(key, group);
        }
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> result = groupAnagrams(input);
        List<List<String>> result_counter = groupAnagramsCounter(input);
        
        for (List<String> group : result) {
            System.out.println(group);
        }

        for (List<String> group : result_counter) {
            System.out.println(group);
        }

    }
}