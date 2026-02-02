import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;

class User {
    String name;
    int age;
}

public class ObjectMapperDemo {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> props)
            throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : props.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Amit");
        map.put("age", 22);

        User user = toObject(User.class, map);
        System.out.println(user.name + " - " + user.age);
    }
}
