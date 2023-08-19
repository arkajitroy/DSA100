import java.util.Arrays;

class Solution {

    public static int brute_linear(int[] arr, int key){
        int index = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                index = i;
                break;
            }
        }
        return index;
    }

    public static int better_binary(int[] arr, int key){
        int lo=0, hi=arr.length - 1, index = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo) / 2;

            if(arr[mid] == key) return mid;

            if(arr[lo] <= arr[mid]){
                if(arr[lo] <= key && key < arr[mid]) hi = mid - 1;
                else lo = mid + 1;
            }
            else{
                if(arr[mid] < key && key <= arr[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        System.out.println("Array : "+Arrays.toString(nums)+" key : "+target);
        System.out.println("Brute Force : "+brute_linear(nums, target));
        System.out.println("Better Approach : "+better_binary(nums, target));
    }    
}
