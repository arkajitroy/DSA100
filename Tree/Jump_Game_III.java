import java.util.*;

class Solution {

    public static boolean canReach(int[] arr, int start){
        int size = arr.length;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(arr[current] == 0) return true;

            // if element is negative keep the loop continue
            if(arr[current] < 0) continue;

            // try both direction
            if(current + arr[current] < size) queue.add(current + arr[current]);
            if(current - arr[current] >= 0) queue.add(current - arr[current]);

            // mark the elements as visited
            arr[current] = -arr[current];

        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean result = canReach(arr, start);
        System.out.println("Can reach 0 from index " + start + ": " + result);
    }    
}
