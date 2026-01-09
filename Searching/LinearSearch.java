package Searching;

public class LinearSearch {

    // Linear Search checks each element of the array one by one to find the target
    // Time Complexity:
    //    Best Case: O(1) -> if the target is the first element
    //    Average Case: O(n) -> target is somewhere in the middle
    //    Worst Case: O(n) -> target is at the end or not present
    // Space Complexity: O(1) -> no extra space used, in-place search
    public static int linearSearch(int[] arr, int target){
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == target) return i; // return index if found
        }
        return -1; // return -1 if target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;
        int index = linearSearch(arr , target);
        System.out.println(index); // Output: 3
    }
}
