class Solution {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = countSetBits(i);
        }

        return result;
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] counts = countBits(n);

        System.out.print("Counts of set bits for numbers from 0 to " + n + ": ");
        for (int i = 0; i <= n; i++) {
            System.out.print(counts[i] + " ");
        }
    }
}

// there is a DP - implementation