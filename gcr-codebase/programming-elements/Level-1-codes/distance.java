// Create a program to convert the distance of 10.8 kilometers to miles.
// Hint: 1 km = 1.6 miles
// I/P => NONE
// O/P => The distance  ___ km in miles is ___

public class Distance {
    public static void main(String[] args) {
        double kilometers = 10.8;
        // kilometer se miles me change karne ke liye kilometer ko 1.6 se divide karenge
        double miles = kilometers / 1.6;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}