class Solution {

    // Using Linear Search : TC-O(n)
    public static int[] bruteForce(int arr[], int key){
        int first= -1, last= -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                if(first == 0) first = i;
                last = i;
            }          
        }
        return new int[]{ first, last };
    }

    // Using Binary Search : TC : O(log n)
    public static int[] betterSolution(int [] arr, int key){
        int first = -1, last = -1;
        int lo= 0, hi = arr.length - 1;

        // find the first occurance
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == key){
                first = mid;
                hi = mid -1;
            }
            else if(arr[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }

        // find the last occurance
        lo = 0;
        hi = arr.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == key){
                last = mid;
                lo = mid + 1;
            }
            else if(arr[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }

        return new int[] {first, last};

    }

    public static void result(int [] result){
        if (result[0] != -1 && result[1] != -1) {
            System.out.println("First Occurrence: " + result[0]);
            System.out.println("Last Occurrence: " + result[1]);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        int[] brute = bruteForce(nums, target);
        result(brute);

        int[] better = betterSolution(nums, target);
        result(better);
    }    
}
