import java.util.Stack;

class Solution {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch == stack.peek()) stack.pop();
            else stack.push(ch);
        }

        // now itterating the stack to compare the latest charecter of the string
        for(char ch: stack){
            result.append(ch);
        }

        return result.toString();
    }

    public static String removeDuplicates_TwoPT(String s){
        int i = 0;
        char[] result = s.toCharArray();

        for(int j = 0; j < s.length(); j++){
            if(i > 0 && result[i-1] == result[j]) j--;
            else{
                result[i] = result[j];
                i++;
            }
        }

        return new String(result, 0, i);
    }

    public static void main(String[] args) {
        String input = "abbaca";
        String result = removeDuplicates(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }    
}
