import java.util.Scanner;

public class FriendComparison {

    // Method to find youngest friend index
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    // Method to find tallest friend index
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] friendNames = {"Amar", "Akbar", "Anthony"};
        int[] friendAges = new int[3];
        double[] friendHeights = new double[3];

        // Taking input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friendNames[i] + ": ");
            friendAges[i] = input.nextInt();

            System.out.print("Enter height of " + friendNames[i] + " (in cm): ");
            friendHeights[i] = input.nextDouble();
        }

        int youngestFriendIndex = findYoungest(friendAges);
        int tallestFriendIndex = findTallest(friendHeights);

        System.out.println("\nYoungest friend is: " + friendNames[youngestFriendIndex]);
        System.out.println("Tallest friend is: " + friendNames[tallestFriendIndex]);

        input.close();
    }
}
