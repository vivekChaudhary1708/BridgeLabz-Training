public class BubbleSortStudentMarks {

    // Method to apply Bubble Sort
    static void bubbleSort(int[] marks) {
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // swap
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // if no swap happened, array already sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Method to print array
    static void printMarks(int[] marks) {
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] studentMarks = {45, 78, 32, 90, 67, 55};

        System.out.println("Marks before sorting:");
        printMarks(studentMarks);

        bubbleSort(studentMarks);

        System.out.println("Marks after sorting:");
        printMarks(studentMarks);
    }
}
