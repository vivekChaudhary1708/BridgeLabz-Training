public class Student {

    // Public variable
    public int rollNumber;

    // Protected variable
    protected String name;

    // Private variable
    private double cgpa;

    // Constructor
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return cgpa;
    }

    // Public setter for CGPA
    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }

    // Main method
    public static void main(String[] args) {

        // Creating PostgraduateStudent object
        PostgraduateStudent pg = new PostgraduateStudent(101, "Amit", 8.6, "AI");

        pg.displayStudent();
        System.out.println("Specialization: " + pg.specialization);

        // Modifying CGPA using setter
        pg.setCGPA(9.1);

        System.out.println("\nAfter CGPA Update:");
        pg.displayStudent();
    }
}

// Subclass
class PostgraduateStudent extends Student {

    String specialization;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }
}
