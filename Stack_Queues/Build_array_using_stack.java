import java.util.*;

class Solution {

    public static List<String> buildArray(int [] target, int n){
        List<String> result = new ArrayList<>();
        int i=0;

        for(int iterator : target){
            while (i != iterator) {
                result.add("Push");
                result.add("Pop");
                i++;
            }
            result.add("Push");
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] target = {1,3};
        int n = 3;

        List<String> operations = buildArray(target, n);
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
    
}
