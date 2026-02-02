import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodDemo {
    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();

        Class<?> cls = calc.getClass();
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

        method.setAccessible(true); // private method access

        Object result = method.invoke(calc, 6, 7);

        System.out.println("Result: " + result);
    }
}
