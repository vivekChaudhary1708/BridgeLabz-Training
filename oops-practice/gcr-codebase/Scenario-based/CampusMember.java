public class CampusMember {

    // Static variables
    private static String universityName = "Global University";
    private static int totalMembers = 0;

    // Instance variables
    private final int rollNumber;   // final variable
    private String name;
    private String grade;

    // Constructor using 'this'
    public CampusMember(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalMembers++;
    }

    // Static method
    public static void displayTotalMembers() {
        System.out.println("Total Students Enrolled: " + totalMembers);
    }

    // Method to display details
    public void displayDetails() {
        if (this instanceof CampusMember) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    // Main method
    public static void main(String[] args) {

        CampusMember student1 = new CampusMember(101, "Hemashree", "A");
        CampusMember student2 = new CampusMember(102, "Rohit", "B");

        CampusMember.displayTotalMembers();

        student1.displayDetails();
        student2.displayDetails();
    }
}
