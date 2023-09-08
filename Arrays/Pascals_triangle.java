import java.util.*;

class Solution {

    // ---------------------------------- (APPROACH 1 : BRUTE FORCE) ------------------------------
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = triangle.get(i - 1);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(sum);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    // ---------------------------------- (APPROACH 2 : Dynamic Programming) ------------------------------
    public static List<List<Integer>> pascal_triangle_DP(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        // Initialize the first row with a single element, which is 1.
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        // Generate the subsequent rows based on the previous row.
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> newRow = new ArrayList<>();

            // The first element of each row is always 1.
            newRow.add(1);

            // Calculate the middle elements based on the previous row.
            for (int j = 1; j < i; j++) {
                int sum = prevRow.get(j - 1) + prevRow.get(j);
                newRow.add(sum);
            }

            // The last element of each row is always 1.
            newRow.add(1);

            // Add the current row to the triangle.
            triangle.add(newRow);
        }

        return triangle;
    }

    // ---------------------------------- (APPROACH 2 : Using Combinations) ------------------------------

    public static List<List<Integer>> pascal_triangle_Combinations(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // Calculate C(i, j) using the combination formula
                int coefficient = calculateCombination(i, j);
                row.add(coefficient);
            }

            triangle.add(row);
        }

        return triangle;
    }

    // Helper function to calculate combination C(n, k)
    private static int calculateCombination(int n, int k) {
        // Calculate C(n, k) = n! / (k! * (n - k)!)
        int numerator = factorial(n);
        int denominator = factorial(k) * factorial(n - k);

        return numerator / denominator;
    }

    // Helper function to calculate factorial of a number
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);

        // Print the Pascal's Triangle
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
