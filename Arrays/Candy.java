class Solution{

    public static int distributeCandies(int[] ratings) {
        int n = ratings.length, totalCandies = 0;
        int[] candies = new int[n];

        // First pass: Distribute candies from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }

        // Second pass: Distribute candies from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies + n; // Add n for the minimum one candy per child
    }

    public static int distributeCandies_SinglePass(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Initialize each child with one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // First pass: Distribute candies from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int totalCandies = candies[n - 1]; // Total candies needed for the last child

        // Second pass: Distribute candies from right to left and update total candies
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        int minCandies = distributeCandies(ratings);
        System.out.println("Minimum number of candies needed: " + minCandies);
    }
}