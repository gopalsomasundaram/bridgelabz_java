package runtimeanalysis;

/*
this class highlights the performance difference between recursive and
iterative approaches for calculating Fibonacci numbers. the recursive
version suffers from exponential time complexity due to overlapping
subproblems, while the iterative version runs in linear time.
*/
public class FibonacciPerformance {

    //recursive approach (O(2^N) complexity)
    public static long fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    //iterative approach (O(N) complexity)
    public static long fibIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 40;

        //measure recursive time
        long start = System.currentTimeMillis();
        System.out.println("Fib(" + n + ") Recursive: " + fibRecursive(n));
        System.out.println("Recursive time: " + (System.currentTimeMillis() - start) + "ms");

        //measure iterative time
        start = System.currentTimeMillis();
        System.out.println("Fib(" + n + ") Iterative: " + fibIterative(n));
        System.out.println("Iterative time: " + (System.currentTimeMillis() - start) + "ms");
    }
}