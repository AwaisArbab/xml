package Recursion;

public class print1toN {

    public static void printAscending(int n) {
        if (n == 0) return;        // Base case
        printAscending(n - 1);     // Recursive call
        System.out.println(n);     // Print after recursion
    }

    public static void main(String[] args) {
        printAscending(5);
    }
}

