package sortings;


import java.util.Arrays;

public class InsertionSort {

    // Insertion Sort inserts each element into its correct position in the sorted part of the array
    // Time Complexity:
    //    Best Case: O(n) -> when the array is already sorted
    //    Average Case: O(n^2)
    //    Worst Case: O(n^2) -> when the array is sorted in reverse order
    // Space Complexity: O(1) -> in-place sorting
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){

            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 55, 23, 54};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
