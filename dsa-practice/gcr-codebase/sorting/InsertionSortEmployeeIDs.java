public class InsertionSortEmployeeIDs {

    // Method to perform Insertion Sort
    static void insertionSort(int[] empIds) {
        int n = empIds.length;

        for (int i = 1; i < n; i++) {
            int key = empIds[i];   // element to be inserted
            int j = i - 1;

            // shift elements greater than key to one position ahead
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j--;
            }

            // insert key at correct position
            empIds[j + 1] = key;
        }
    }

    // Method to print array
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] employeeIds = {105, 102, 110, 101, 108};

        System.out.println("Employee IDs before sorting:");
        printArray(employeeIds);

        insertionSort(employeeIds);

        System.out.println("Employee IDs after sorting:");
        printArray(employeeIds);
    }
}
