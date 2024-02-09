import java.util.Stack;

class Main {
    // O(n) | O(1)
    public static int maxDepth_Itterative(String s){
        int maxDepth = 0, currentDepth = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }else if(ch == ')') currentDepth--;
        }
        return maxDepth;
    }

    // O(n) | O(n)
    public static int maxDepth_Stack(String s){
        int maxDepth = 0;
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                maxDepth = Math.max(maxDepth, stack.size());
            }else if(ch == ')') stack.pop();
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String str = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum Depth of the Parenthesis IIterative: "+ maxDepth_Itterative(str));
        System.out.println("Maximum Depth of the Parenthesis Stack: "+ maxDepth_Stack(str));
    }
}
