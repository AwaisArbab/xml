package Recursion;

public class ImportantRecursion {

    // 1. Factorial of N
    // Time Complexity: O(n)
    // Space Complexity: O(n)  (due to recursion stack)
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // 2. Fibonacci Number
    // Time Complexity: O(2^n)  (exponential due to two recursive calls)
    // Space Complexity: O(n)   (recursion tree height)
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 3. Power Function (x^n)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    // 4. Count digits of a number
    // Time Complexity: O(d) where d = number of digits
    // Space Complexity: O(d)
    public static int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    // 5. Sum of digits
    // Time Complexity: O(d)
    // Space Complexity: O(d)
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumDigits(n / 10);
    }

    // 6. GCD using recursion
    // Time Complexity: O(log(min(a,b)))
    // Space Complexity: O(log(min(a,b)))
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // 7. Recursive Binary Search
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target)
            return binarySearch(arr, left, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, right, target);
    }

    // 8. Print array in reverse order
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void printArrayReverse(int[] arr, int index) {
        if (index < 0) return;
        System.out.print(arr[index] + " ");
        printArrayReverse(arr, index - 1);
    }

    // 9. Find maximum in array
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        return Math.max(arr[index], findMax(arr, index + 1));
    }

    // 10. Check if array is sorted
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) return false;
        return isSorted(arr, index + 1);
    }

    // 11. Linear Search using recursion
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int linearSearch(int[] arr, int index, int target) {
        if (index == arr.length) return -1;
        if (arr[index] == target) return index;
        return linearSearch(arr, index + 1, target);
    }

    // Main method to test
    public static void main(String[] args) {

        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("2^5: " + power(2, 5));
        System.out.println("Digits in 12345: " + countDigits(12345));
        System.out.println("Sum of digits of 1234: " + sumDigits(1234));
        System.out.println("GCD of 48 and 18: " + gcd(48, 18));

        int[] arr = {2, 4, 6, 8, 10};

        System.out.println("Binary Search for 8: index = " +
                binarySearch(arr, 0, arr.length - 1, 8));

        System.out.print("Array reversed: ");
        printArrayReverse(arr, arr.length - 1);
        System.out.println();

        System.out.println("Max in array: " + findMax(arr, 0));
        System.out.println("Array sorted? " + isSorted(arr, 0));

        System.out.println("Linear Search for 6: index = " +
                linearSearch(arr, 0, 6));
    }
}
