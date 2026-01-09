package Recursion;

public class printNto1 {

    public static void printDescending(int n) {
        if (n == 0) return;       // Base case
        System.out.println(n);    // Print first
        printDescending(n - 1);   // Recursive call
    }

    public static void main(String[] args) {
        printDescending(5);
    }
}

