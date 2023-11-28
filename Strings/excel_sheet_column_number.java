class Solution{
    // itterative method
    public static int titleToNumber(String s){
        int result = 0;
        for(int i=0; i<s.length(); i++){
            result *= 26;
            result += (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    // recursive method
    public static int titleToNumber_recursive(String s){
        if (s.isEmpty()) {
            return 0;
        }
        int numericValue = s.charAt(s.length() - 1) - 'A' + 1;
        return numericValue + 26 * titleToNumber(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        String columnTitle = "AB";
        int columnNumber = titleToNumber_recursive(columnTitle);
        System.out.println("Column Number for '" + columnTitle + "': " + columnNumber);
    }
}