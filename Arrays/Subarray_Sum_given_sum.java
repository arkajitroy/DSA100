import java.util.ArrayList;
import java.util.HashMap;

class Main{
    // using hashmap and prefix sum
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int target){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        map.put(0, -1);

        for(int i=0; i<n; i++){
            sum += arr[i];

            if(map.containsKey(sum - target)){
                int startIndex = map.get(sum-target)+1;
                int endIndex = i;
                result.add(startIndex + 1);
                result.add(endIndex + 1);
                return result;
            }
            map.put(sum, i);
        }
        result.add(-1);
        return result;
    }

    // using sliding window
    public static ArrayList<Integer> subarraySumSlidingWindow(int[] arr, int n, int target){
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = 0, sum = 0;
        while (right < n) {
            sum += arr[right];
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if(sum == target){
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
            right++;
        }
        result.add(-1);
        return result;
    }



    public static void main(String[] args) {
        int arr[] = { 1, 4, 20, 3, 10, 5 };
        int size = arr.length, target = 33;

        ArrayList<Integer> indexes = subarraySum(arr, size, target);
    }
}