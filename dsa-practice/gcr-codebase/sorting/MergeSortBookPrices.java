public class MergeSortBookPrices {

    // Merge Sort method
    static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // sort first half
            mergeSort(prices, left, mid);

            // sort second half
            mergeSort(prices, mid + 1, right);

            // merge both halves
            merge(prices, left, mid, right);
        }
    }

    // Merge two sorted halves
    static void merge(int[] prices, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = prices[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // merge the temp arrays
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }

    // Print array
    static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] bookPrices = {450, 120, 999, 300, 150, 700};

        System.out.println("Book prices before sorting:");
        printArray(bookPrices);

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("Book prices after sorting:");
        printArray(bookPrices);
    }
}
