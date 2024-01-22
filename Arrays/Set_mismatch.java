import java.util.HashSet;

class Main{
    public static int[] findErrorNums_Set(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int duplicate = -1, missing = -1;
        int actualSum = 0;
        int expectedSum = nums.length * (nums.length + 1) / 2;
        
        for (int num : nums) {
            if (seen.contains(num)) duplicate = num;
            seen.add(num);
            actualSum += num;
        }
        missing = expectedSum - (actualSum - duplicate);
        return new int[]{duplicate, missing};
    }

    public static int[] findErrorNums(int[] nums) {
        int[] seen = new int[nums.length+1];
        int duplicate = 0, missing = 0;
        
        // setting the values in the set
        for(int num : nums){
            seen[num]++;
        }

        // searching for the values
        for(int i=1; i<seen.length; i++){
            if(seen[i] == 2) duplicate = i;
            if(seen[i] == 0) missing = i;
        }

        return new int[]{ duplicate, missing };
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNums(nums);

        System.out.println("Duplicate: " + result[0]);
        System.out.println("Missing: " + result[1]);
    }
}