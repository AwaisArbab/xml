package Recursion;

public class SumOfN {
    // Time Complexity:  O(N)
// Space Complexity: O(N)

    public static int sum(int n) {
        if (n == 0) return 0;      // Base case
        return n + sum(n - 1);     // Recursive call
    }

    public static void main(String[] args) {
        System.out.println(sum(5));  // Output: 15
    }
}

