class Solution {
    // nested loop - O(n^2)
    public static int brute(int[] arr, int n){
        int maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int h = Math.min(arr[i], arr[j]);
                int w = j - i;
                int area = h * w;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // two pointer approach - O(n)

    public static int optimal(int[] arr, int n){
        int maxArea = 0, left = 0, right = n-1;

        while (left < right) {
            int h = Math.min(arr[left], arr[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            if (arr[left] < arr[right]) left++;
            else right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        
        int result_brute = brute(heights, heights.length);
        System.out.println("Result - Brute : "+result_brute);

        int result_optimal = optimal(heights, heights.length);
        System.out.println("Result - Optimal : "+result_optimal);
    }
}