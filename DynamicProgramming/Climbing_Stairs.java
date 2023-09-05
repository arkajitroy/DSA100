class Solution {

    // Using Recurssion - O(n^2)
    public static int climbStairRecurssion(int n){
        return recursionHelper(0, n);
    }

    private static int recursionHelper(int curr, int total){
        if(curr == total) return 1;
        if(curr > total) return 0;
        return recursionHelper(curr+1, total);
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    } 

    public static void main(String[] args) {
        int stairs = 4;
        int ways_recc = climbStairRecurssion(stairs);
        int ways_DP = climbStairs(stairs);

        System.out.println("No of ways (recurssion) => "+ ways_recc);
        System.out.println("No of ways (DP) => "+ ways_DP);
    }
}
