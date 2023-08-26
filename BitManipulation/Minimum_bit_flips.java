class Solution {
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int flipped = 0;
        while(xor > 0){
            flipped += xor & 1;
            xor >>= 1;
        }
        return flipped;
    }

    public static int kernighansMethod(int start, int goal) {
        int xor = start ^ goal;
        int flipped = 0;
        while(xor > 0){
            xor &= (xor - 1);
            flipped++;
        }
        return flipped;
    }

    public static void main(String[] args) {
        int start = 7; // Example input
        int goal = 10; // Example input

        int minFlipsRequired = minBitFlips(start, goal);
        int minFlipsRequiredKernighans = minBitFlips(start, goal);
        
        System.out.println("Minimum Bit Flips Required: (XOR Approach)" + minFlipsRequired);
        System.out.println("Minimum Bit Flips Required: (Kernighans Approach)" + minFlipsRequiredKernighans);
    }
}