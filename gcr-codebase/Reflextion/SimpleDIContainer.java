import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car {
    @Inject
    Engine engine;

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}

public class SimpleDIContainer {

    public static <T> T createObject(Class<T> cls) throws Exception {

        T obj = cls.getDeclaredConstructor().newInstance();

        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency =
                        field.getType().getDeclaredConstructor().newInstance();
                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Car car = createObject(Car.class);
        car.drive();
    }
}
