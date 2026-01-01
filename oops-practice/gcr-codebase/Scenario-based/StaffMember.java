public class StaffMember {

    // Static variables
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;

    // Instance variables
    private final int id;     // final variable
    private String name;
    private String designation;

    // Constructor using 'this'
    public StaffMember(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display staff details
    public void displayStaffDetails() {
        if (this instanceof StaffMember) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    // Main method
    public static void main(String[] args) {

        StaffMember emp1 = new StaffMember(101, "Thamarai", "Software Engineer");
        StaffMember emp2 = new StaffMember(102, "Rohan", "Project Manager");

        StaffMember.displayTotalEmployees();

        emp1.displayStaffDetails();
        emp2.displayStaffDetails();
    }
}
