package Recursion;

public class reverseNum {

    public static int reverse(int n, int rev) {
        if (n == 0) return rev;                     // Base case
        return reverse(n / 10, rev * 10 + n % 10);  // Recursive call
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println(reverse(num, 0));  // Output: 54321
    }
}

