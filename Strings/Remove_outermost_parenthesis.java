import java.util.Stack;

class Main{
    // using stack : O(n) | O(n)
    public static String removeOuterParentheses(String S){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int start = 0;
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '('){
                stack.push(ch);
                if(stack.size() == 1) start = i+1;
            }else{
                stack.pop();
                if(stack.isEmpty()) result.append(S.substring(start, i));
            }
        }
        return result.toString();
    }

    // using counting array : O(n) | O(1)
    public static String removeOuterParentheses_Counting(String S){
        StringBuilder result = new StringBuilder();
        int openCount = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (openCount > 0) result.append(c);
                openCount++;
            } else {
                openCount--;
                if (openCount > 0) result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "(()())(())";
        System.out.println("Result: " + removeOuterParentheses(input));
    }
}