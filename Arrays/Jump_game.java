package ArraysProblem;

class Main {
    public static boolean canJump(int[] nums){
        int maxReach = 0, n = nums.length;

        for(int i=0; i<n; i++){
            if(i>maxReach) return false;
            maxReach = Math.max(maxReach, i + maxReach);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = canJump(nums);
        System.out.println("Can reach the last index: " + result);
    }    
}
