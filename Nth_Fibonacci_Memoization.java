public class Nth_Fibonacci_Memoization {
    
    // Time Complexity: O(2^n)
    static int recursiveFib (int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return recursiveFib (n - 1) + recursiveFib (n - 2); 
    }
    
    // Time Complexity: O(n)
    // For call fib(n), fib(n-1) & fib(n-2) is already calculated, we just have to look up for it.
    static int[] memo;  // Initialized with (n + 1) size.
    static int fib (int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println(recursiveFib(n));

        memo = new int[n + 1];
        System.out.println(fib(n));
    }
}