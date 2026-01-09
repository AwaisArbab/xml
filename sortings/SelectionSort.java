package sortings;

import java.util.Arrays;

public class SelectionSort {

    static int[] selectionSort(int[] arr){
        // Selection Sort works by repeatedly finding the minimum element from the unsorted part
        // and putting it at the beginning.
        // Time Complexity:
        //   Best Case: O(n^2)
        //   Average Case: O(n^2)
        //   Worst Case: O(n^2)
        // Space Complexity: O(1) - in-place sorting, no extra array is used
        for(int i = 0 ; i < arr.length; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            // Swap arr[i] and arr[min]
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
