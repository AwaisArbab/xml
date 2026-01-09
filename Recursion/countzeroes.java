package Recursion;

public class countzeroes {

    public static int countZeros(int n) {
        // Handle negative numbers
        if (n < 0) {
            return countZeros(-n);
        }

        // Base case: when number becomes 0
        if (n == 0) {
            return 1; // because 0 has one zero digit
        }

        // If number becomes a single digit (not zero)
        if (n < 10) {
            return n == 0 ? 1 : 0;
        }

        // Recursive case (single recursive call)
        int lastDigit = n % 10;
        int countForCurrent = (lastDigit == 0) ? 1 : 0;

        return countForCurrent + countZeros(n / 10);
    }

    public static void main(String[] args) {
        int num = 10203040;
        System.out.println("Zero count = " + countZeros(num));
    }
}
