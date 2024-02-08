import java.util.*;

class Main {
    public static String frequencySort(String s){
        if (s == null || s.length() == 0) return "";
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entryList, (a, b) -> b.getValue() - a.getValue());
        
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public String frequencySort_Heap(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        maxHeap.addAll(frequencyMap.entrySet());
        
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String strInput1 = "leetcode";
        String strInput2 = "geeksforgeeks";
    }    
}
