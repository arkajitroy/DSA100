import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static List<List<String>> groupAnagrams_brute(String[] strs){
        HashMap<String, List<String>> groups= new HashMap<>();

        for(String str : strs){
            char []charArray = str.toCharArray();
            Arrays.sort(charArray);

            // coverting the sorted array to string
            String sorted = new String(charArray);

            if(!groups.containsKey(sorted)) groups.put(sorted, new ArrayList<>());

            groups.get(sorted).add(str);
        }

        List<List<String>> result = new ArrayList<>(groups.values());
        return result;
    }

    public static List<List<String>> groupAnagrams_better(String[] strs){
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            int[] charCount = new int[26]; // Assuming lowercase English letters only
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            String countKey = Arrays.toString(charCount);

            if (!anagramGroups.containsKey(countKey)) anagramGroups.put(countKey, new ArrayList<>());
            anagramGroups.get(countKey).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public static void printResult(List<List<String>> groups){
        // Print the result
        for (List<String> group : groups) {
            System.out.println(group);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> anagramGroups_brute = groupAnagrams_brute(strs);
        System.out.println("Brute Force approach");
        printResult(anagramGroups_brute);

        List<List<String>> anagramGroups_better = groupAnagrams_better(strs);
        System.out.println("Better approach");
        printResult(anagramGroups_better);
    }
}
