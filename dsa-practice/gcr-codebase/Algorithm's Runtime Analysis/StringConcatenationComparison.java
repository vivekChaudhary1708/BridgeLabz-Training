public class StringConcatenationComparison {

    public static void main(String[] args) {

        int N = 100_000; // test ke liye (1,000,000 pe String bahut slow hoga)

        // ---------- Using String ----------
        long startString = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str = str + "a";
        }
        long endString = System.nanoTime();

        // ---------- Using StringBuilder ----------
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long endBuilder = System.nanoTime();

        // ---------- Using StringBuffer ----------
        long startBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbuf.append("a");
        }
        long endBuffer = System.nanoTime();

        // ---------- Output ----------
        System.out.println("Operations Count: " + N);
        System.out.println("String Time: " + (endString - startString) / 1_000_000.0 + " ms");
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) / 1_000_000.0 + " ms");
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) / 1_000_000.0 + " ms");
    }
}
