import java.util.*;

class Solution {
    public static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> helperStack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int idx=0; idx<temperatures.length; idx++){
            while(!helperStack.isEmpty() && temperatures[idx] > temperatures[helperStack.peek()]){
                int prevStackIdx = helperStack.pop();
                result[prevStackIdx] = idx - prevStackIdx;
            }
            helperStack.push(idx);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);

        System.out.println("Input Temperatures: " + Arrays.toString(temperatures));
        System.out.println("Result: " + Arrays.toString(result));
    }
}
