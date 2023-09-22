class Solution {

    public static boolean isSubsequence(String str1, String str2){
        int pt1=0, pt2=0;

        if(str1.length() == 0) return true;

        while(pt2 < str2.length()){
            if(str1.charAt(pt1) == str2.charAt(pt2)) pt1++;
            if(pt1 == str1.length()) return true;
            pt2++;
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ahbgdc";

        Boolean result = isSubsequence(str1, str2);
        System.out.println("Is string A is a valid substring of B => "+ result);
    }
}