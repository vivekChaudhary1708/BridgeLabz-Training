public class FibonacciComparison {

    // -------- Recursive Fibonacci (O(2^n)) --------
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // -------- Iterative Fibonacci (O(n)) --------
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        int n = 30; // Recursive ke liye bada value mat lena

        // -------- Recursive Time --------
        long startRecursive = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long endRecursive = System.nanoTime();

        // -------- Iterative Time --------
        long startIterative = System.nanoTime();
        int itrResult = fibonacciIterative(n);
        long endIterative = System.nanoTime();

        double recursiveTime = (endRecursive - startRecursive) / 1_000_000.0;
        double iterativeTime = (endIterative - startIterative) / 1_000_000.0;

        // -------- Output --------
        System.out.println("Fibonacci Number: " + n);
        System.out.println("Recursive Result: " + recResult);
        System.out.println("Iterative Result: " + itrResult);

        System.out.println("Recursive Time: " + recursiveTime + " ms");
        System.out.println("Iterative Time: " + iterativeTime + " ms");
    }
}
