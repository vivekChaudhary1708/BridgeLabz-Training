public class Course {

    // Instance Variables
    String courseName;
    int duration;        // in months
    double fee;

    // Class Variable (shared by all courses)
    static String instituteName = "Tech Academy";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance Method
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class Method
    public static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    // Main Method
    public static void main(String[] args) {

        Course c1 = new Course("Java Full Stack", 6, 45000);
        Course c2 = new Course("MERN Stack", 5, 50000);

        System.out.println("Before Updating Institute Name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        // Update institute name
        Course.updateInstituteName("Code Academy");

        System.out.println("\nAfter Updating Institute Name:");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}
