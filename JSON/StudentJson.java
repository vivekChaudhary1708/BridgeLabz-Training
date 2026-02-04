import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class StudentJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> student = new HashMap<>();
        student.put("name", "Vivek");
        student.put("age", 22);
        student.put("subjects", List.of("Java", "DSA", "Web"));

        String json = mapper.writeValueAsString(student);
        System.out.println(json);
    }
}
