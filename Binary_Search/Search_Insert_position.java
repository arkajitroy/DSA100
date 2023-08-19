class Solution {
    public static int searchInsertElement(int []arr, int key){
        int lo=0, hi=arr.length-1;
        int res = arr.length;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] >= key){
                res = mid;
                hi = mid - 1;
            }else lo = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9};
        int elementToInsert = 4;

        int result = searchInsertElement(sortedArray, elementToInsert);
        System.out.println("Element position will be :"+ (result+1));
    }
}

/* PROBLEM LINK : https://www.codingninjas.com/studio/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries */