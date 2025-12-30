import java.util.Scanner;

public class ChocolateDistribution {

    // Method to find chocolates per child and remaining chocolates
    public static int[] findRemainderAndQuotient(int totalChocolates, int totalChildren) {

        int chocolatesPerChild = totalChocolates / totalChildren;
        int leftoverChocolates = totalChocolates % totalChildren;

        return new int[]{chocolatesPerChild, leftoverChocolates};
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = inputReader.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = inputReader.nextInt();

        int[] distributionResult =
                findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Each child will get: " + distributionResult[0] + " chocolates");
        System.out.println("Remaining chocolates: " + distributionResult[1]);

        inputReader.close();
    }
}
