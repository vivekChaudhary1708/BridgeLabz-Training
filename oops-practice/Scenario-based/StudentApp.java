import java.util.*;

class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String msg) {
        super(msg);
    }
}

abstract class RegistrationService {
    public abstract void enroll(Course c) throws CourseLimitExceededException;
    public abstract void drop(Course c);
    public abstract void viewGrades();
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private int maxCourses = 3;
    private List<Course> courses = new ArrayList<>();
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String name) {
        super(name);
    }

    public void enroll(Course c) throws CourseLimitExceededException {
        if (courses.size() >= maxCourses) {
            throw new CourseLimitExceededException("Course limit reached");
        }
        courses.add(c);
        grades.put(c.courseName, 0);
        System.out.println(getName() + " enrolled in " + c.courseName);
    }

    public void drop(Course c) {
        courses.remove(c);
        grades.remove(c.courseName);
        System.out.println(getName() + " dropped " + c.courseName);
    }

    public void setGrade(String courseName, int grade) {
        grades.put(courseName, grade);
    }

    public void viewGrades() {
        System.out.println("Grades of " + getName());
        for (String c : grades.keySet()) {
            System.out.println(c + " : " + grades.get(c));
        }
    }
}

class Course {
    String courseName;

    public Course(String name) {
        this.courseName = name;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Student s1 = new Student("Vivek");

        Course c1 = new Course("Java");
        Course c2 = new Course("DSA");
        Course c3 = new Course("DBMS");
        Course c4 = new Course("AI");

        try {
            s1.enroll(c1);
            s1.enroll(c2);
            s1.enroll(c3);
            s1.enroll(c4);
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        s1.setGrade("Java", 85);
        s1.setGrade("DSA", 90);

        s1.viewGrades();

        s1.drop(c2);
        s1.viewGrades();
    }
}
