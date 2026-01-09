package Searching;


public class BinarySearch {

    // Binary Search works on a **sorted array** by repeatedly dividing the search interval in half.
    // Time Complexity:
    //    Best Case: O(1) -> target is at the middle index
    //    Average Case: O(log n)
    //    Worst Case: O(log n)
    // Space Complexity: O(1) -> iterative version uses constant space
    public static void main(String[] args) {
        int[] arr = {10, 20, 45, 49, 55, 60}; // sorted array

        int index = binary(arr, 45); // search for 45
        System.out.println(index);   // Output: 2
    }

    static int binary(int[] arr, int target){
        int start = 0;
        int end  = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2; // Correct way to avoid overflow

            if(target == arr[mid]){
                return mid; // target found
            }
            if(target > arr[mid]){
                start = mid + 1; // search in right half
            } else {
                end = mid - 1; // search in left half
            }
        }
        return -1; // target not found
    }
}
