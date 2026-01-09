package Recursion;

public class print1toN {
    // Time Complexity:  O(N)
// Space Complexity: O(N)  (recursion stack)
    public static void printAscending(int n) {
        if (n == 0) return;        // Base case
        printAscending(n - 1);     // Recursive call
        System.out.println(n);     // Print after recursion
    }

    public static void main(String[] args) {
        printAscending(5);
    }
}

