import java.lang.annotation.*;
import java.lang.reflect.*;

// Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Vivek Bhai")
class Book {
}

public class AnnotationDemo {
    public static void main(String[] args) {

        Class<Book> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }
    }
}
