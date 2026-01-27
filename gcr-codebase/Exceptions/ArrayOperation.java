import java.util.Scanner;

public class ArrayOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int[] arr = {10, 20, 30, 40, 50};

            System.out.print("Enter index: ");
            int index = sc.nextInt();

            System.out.println("Value at index " + index + " is: " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of range");

        } catch (NullPointerException e) {
            System.out.println("Error: Array is null");
        }

        sc.close();
    }
}
