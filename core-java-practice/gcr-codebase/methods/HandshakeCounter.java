import java.util.Scanner;

public class HandshakeCounter {

    // Method to calculate maximum handshakes
    static int calculateHandshakes(int totalStudents) {
        return (totalStudents * (totalStudents - 1)) / 2;
    }

    public static void main(String[] args) {

        Scanner inputBox = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = inputBox.nextInt();

        int possibleHandshakes = calculateHandshakes(numberOfStudents);

        System.out.println("Maximum possible handshakes: " + possibleHandshakes);

        inputBox.close();
    }
}
