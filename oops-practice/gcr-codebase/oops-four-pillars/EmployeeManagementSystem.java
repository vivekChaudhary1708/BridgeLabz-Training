// Interface
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract Class
abstract class Employee {

    // Encapsulation: private fields
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getter & Setter
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
    }

    // Abstract method
    abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Full Time Employee
class FullTimeEmployee extends Employee implements Department {

    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateSalary() {
        return getBaseSalary(); // fixed salary
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Part Time Employee
class PartTimeEmployee extends Employee implements Department {

    private int workHours;
    private String department;

    public PartTimeEmployee(int id, String name, double hourlyRate, int workHours) {
        super(id, name, hourlyRate);
        this.workHours = workHours;
    }

    @Override
    double calculateSalary() {
        return getBaseSalary() * workHours; // hourly based
    }

    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return department;
    }
}

// Main Class
public class EmployeeManagementSystem {

    public static void main(String[] args) {

        // Polymorphism: Employee reference
        Employee[] employees = new Employee[2];

        employees[0] = new FullTimeEmployee(101, "Rahul", 50000);
        employees[1] = new PartTimeEmployee(102, "Aman", 500, 40);

        ((Department) employees[0]).assignDepartment("IT");
        ((Department) employees[1]).assignDepartment("Support");

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("Department: " +
                    ((Department) emp).getDepartmentDetails());
            System.out.println();
        }
    }
}
