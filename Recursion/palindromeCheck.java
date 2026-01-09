package Recursion;

public class palindromeCheck {
    // Time Complexity:  O(d)
// Space Complexity: O(d)
    public static int reverse(int n, int rev) {
        if (n == 0) return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }

    public static boolean isPalindrome(int n) {
        return n == reverse(n, 0);
    }

    public static void main(String[] args) {
        int num = 1221;
        System.out.println(isPalindrome(num));  // true
    }
}
