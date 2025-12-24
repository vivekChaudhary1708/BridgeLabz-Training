import java.util.Scanner;

public class SimpleInterestCalculator {

    // Method to calculate simple interest
    static double findSimpleInterest(double loanAmount, double interestRate, double durationInYears) {
        return (loanAmount * interestRate * durationInYears) / 100;
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter Principal Amount: ");
        double principalMoney = inputReader.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rateOfInterest = inputReader.nextDouble();

        System.out.print("Enter Time (in years): ");
        double timePeriod = inputReader.nextDouble();

        double simpleInterest =
                findSimpleInterest(principalMoney, rateOfInterest, timePeriod);

        System.out.println(
            "The Simple Interest is " + simpleInterest +
            " for Principal " + principalMoney +
            ", Rate of Interest " + rateOfInterest +
            " and Time " + timePeriod
        );

        inputReader.close();
    }
}
