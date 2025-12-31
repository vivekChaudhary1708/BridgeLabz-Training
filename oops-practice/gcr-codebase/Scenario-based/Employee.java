public class Employee {

    // Public variable
    public int employeeID;

    // Protected variable
    protected String department;

    // Private variable
    private double salary;

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + salary);
    }

    // Main method
    public static void main(String[] args) {

        Manager manager = new Manager(101, "IT", 55000, "Team Lead");

        manager.displayManagerDetails();

        // Modify salary using setter
        manager.setSalary(65000);

        System.out.println("\nAfter Salary Update:");
        manager.displayManagerDetails();
    }
}

// Subclass
class Manager extends Employee {

    String designation;

    public Manager(int employeeID, String department, double salary, String designation) {
        super(employeeID, department, salary);
        this.designation = designation;
    }

    public void displayManagerDetails() {
        System.out.println("Employee ID: " + employeeID);     // public
        System.out.println("Department: " + department);       // protected
        System.out.println("Designation: " + designation);
        System.out.println("Salary: ₹" + getSalary());         // private via getter
    }
}
