import java.util.Arrays;

class Solution {

    public static void findFloorCeil(int []arr, int key){
        int lo=0, hi=arr.length, floor= -1, ceil = -1;

        while(lo<=hi){
            int mid = lo + (hi-lo) / 2;
            if(arr[mid] == key){
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }else if(arr[mid] < key){
                floor = arr[mid];
                lo = mid + 1;
            }else {
                ceil = arr[mid];
                hi = mid - 1;
            }
        }
        System.out.println("Array - "+Arrays.toString(arr));
        System.out.println("Target : "+key+"| floor : "+floor+"| ceil :"+ceil);
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 8, 10, 10, 12, 19};
        int target = 5;

        findFloorCeil(sortedArray, target);
    }    
}
