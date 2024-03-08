import java.util.HashMap;
import java.util.Map;

class Main{
    public static int maxFrequencyElements(int[] nums){
        int total = 0, maximum = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int val : map.values()){
            maximum = Math.max(maximum, val);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(maximum == entry.getValue()) total += entry.getValue();
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
        System.out.println("Count Element with maxium freq :" + maxFrequencyElements(nums));
    }
}