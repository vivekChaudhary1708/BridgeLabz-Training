import java.util.Scanner;

public class RandomStats {

    // Method to generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {

        int[] randomNumbers = new int[size];

        for (int i = 0; i < size; i++) {
            // Generates random 4-digit number (1000 to 9999)
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
        }

        return randomNumbers;
    }

    // Method to find average, minimum and maximum
    // index 0 → average, index 1 → min, index 2 → max
    public static double[] findAverageMinMax(int[] numbers) {

        int sum = 0;
        int minValue = numbers[0];
        int maxValue = numbers[0];

        for (int value : numbers) {
            sum += value;
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        }

        double average = (double) sum / numbers.length;

        return new double[]{average, minValue, maxValue};
    }

    public static void main(String[] args) {

        int size = 5;

        int[] randomValues = generate4DigitRandomArray(size);

        System.out.println("Generated 4-digit random numbers:");
        for (int value : randomValues) {
            System.out.print(value + " ");
        }

        double[] results = findAverageMinMax(randomValues);

        System.out.println("\n\nAverage value: " + results[0]);
        System.out.println("Minimum value: " + results[1]);
        System.out.println("Maximum value: " + results[2]);
    }
}
