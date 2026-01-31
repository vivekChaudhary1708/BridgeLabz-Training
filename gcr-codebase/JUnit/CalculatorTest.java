class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(5, 5));
        System.out.println(c.subtract(5, 3));
        System.out.println(c.multiply(5, 3));

        try {
            System.out.println(c.divide(10, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
