import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class PrivateFieldDemo {
    public static void main(String[] args) throws Exception {

        Person p = new Person();

        Class<?> cls = p.getClass();
        Field field = cls.getDeclaredField("age");

        field.setAccessible(true); // private field access

        field.set(p, 25); // value set
        int value = (int) field.get(p); // value get

        System.out.println("Age is: " + value);
    }
}
