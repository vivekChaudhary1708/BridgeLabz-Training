public class SelectionSortExamScores {

    // Method to perform Selection Sort
    static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // find index of minimum element
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // swap minimum element with first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Method to print array
    static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] examScores = {78, 45, 90, 62, 88, 55};

        System.out.println("Exam scores before sorting:");
        printArray(examScores);

        selectionSort(examScores);

        System.out.println("Exam scores after sorting:");
        printArray(examScores);
    }
}
