class Main{
    // O(m * n)
    public static String firstPalindrome(String[] words){
        for(String w: words){
            int l=0, r=w.length()-1;
            while(l<r){
                if(w.charAt(l) != w.charAt(r)) break;
                l++;
                r--;
            }
            if(l>=r) return w;
        }
        return "";
    }

    // O(n)
    public static String firstPalindrome_Optimal(String[] words) {
        for(int str = 0; str < words.length; str++){
            if (isPalindrome(words[str])){
                return words[str];
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str){
        if(str== null || str.length() == 0){
            return false;
        }
        for(int i = 0; i < str.length()/2; i++){
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            if(start != end){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"abc","car","ada","racecar","cool"};
        System.out.println("Solution of firstPalindrome_Optimal"+ firstPalindrome_Optimal(strs));
        System.out.println("Solution of firstPalindrome"+ firstPalindrome(strs));
    }
}