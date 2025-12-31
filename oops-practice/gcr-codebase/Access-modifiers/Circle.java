public class Circle {

    double radius;

    // Default constructor
    public Circle() {
        this(1.0); // calling parameterized constructor
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to display details
    public void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
    }
}
