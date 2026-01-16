public class CountingSortStudentAges {

    static void countingSort(int[] ages) {

        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];

        // Step 1: Count frequency
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Rebuild sorted array
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                ages[index] = i + minAge;
                index++;
                count[i]--;
            }
        }
    }

    // Print array
    static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] studentAges = {12, 15, 10, 18, 14, 13, 15, 11};

        System.out.println("Student ages before sorting:");
        printArray(studentAges);

        countingSort(studentAges);

        System.out.println("Student ages after sorting:");
        printArray(studentAges);
    }
}
