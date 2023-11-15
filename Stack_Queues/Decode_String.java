import java.util.Stack;

class Solution{

    public static String decodeString(String s){
        Stack<Integer> numberStack = new Stack<>();
        Stack<Integer> stringStack = new Stack<>();

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)) currNum = currNum * 10 + (ch - 'O')
        }
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String result = decodeString(s);
        System.out.println(result);
    }
}