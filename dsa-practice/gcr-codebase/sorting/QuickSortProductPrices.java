public class QuickSortProductPrices {

    // Quick Sort method
    static void quickSort(int[] prices, int low, int high) {
        if (low < high) {

            // find partition index
            int p = partition(prices, low, high);

            // sort left part
            quickSort(prices, low, p - 1);

            // sort right part
            quickSort(prices, p + 1, high);
        }
    }

    // Partition method (pivot = last element)
    static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // place pivot at correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Print array
    static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] productPrices = {1200, 450, 999, 300, 1500, 700};

        System.out.println("Product prices before sorting:");
        printArray(productPrices);

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Product prices after sorting:");
        printArray(productPrices);
    }
}
