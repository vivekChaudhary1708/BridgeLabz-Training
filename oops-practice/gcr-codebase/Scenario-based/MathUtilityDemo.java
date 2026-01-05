class MathUtility {

    static int factorial(int n) {
        if (n < 0) return -1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

public class MathUtilityDemo {

    public static void main(String[] args) {

        System.out.println(MathUtility.factorial(5));
        System.out.println(MathUtility.factorial(0));

        System.out.println(MathUtility.isPrime(7));
        System.out.println(MathUtility.isPrime(1));

        System.out.println(MathUtility.gcd(20, 8));

        System.out.println(MathUtility.fibonacci(6));
        System.out.println(MathUtility.fibonacci(0));
    }
}
