import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearchComparison {

    // -------- Array Linear Search --------
    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int N = 1_000_000;   // Dataset size
        int target = N - 1;

        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        // -------- Fill Data --------
        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        // -------- Array Search Time --------
        long startArray = System.nanoTime();
        arraySearch(array, target);
        long endArray = System.nanoTime();

        // -------- HashSet Search Time --------
        long startHashSet = System.nanoTime();
        hashSet.contains(target);
        long endHashSet = System.nanoTime();

        // -------- TreeSet Search Time --------
        long startTreeSet = System.nanoTime();
        treeSet.contains(target);
        long endTreeSet = System.nanoTime();

        double arrayTime = (endArray - startArray) / 1_000_000.0;
        double hashSetTime = (endHashSet - startHashSet) / 1_000_000.0;
        double treeSetTime = (endTreeSet - startTreeSet) / 1_000_000.0;

        // -------- Output --------
        System.out.println("Dataset Size: " + N);
        System.out.println("Array Search Time: " + arrayTime + " ms");
        System.out.println("HashSet Search Time: " + hashSetTime + " ms");
        System.out.println("TreeSet Search Time: " + treeSetTime + " ms");
    }
}
