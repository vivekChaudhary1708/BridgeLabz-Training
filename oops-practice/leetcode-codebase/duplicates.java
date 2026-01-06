import java.util.HashSet;

class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 3};

        HashSet<Integer> set = new HashSet<>();

        System.out.println("Duplicate elements are:");
        for (int i = 0; i < arr.length; i++) {
            if (!set.add(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }
}
