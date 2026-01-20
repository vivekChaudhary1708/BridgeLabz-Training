import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class LargeFileReadComparison {

    // -------- FileReader (Character Stream) --------
    public static void readUsingFileReader(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        while (reader.read() != -1) {
            // sirf read kar rahe hain, process nahi
        }
        reader.close();
    }

    // -------- InputStreamReader (Byte -> Character) --------
    public static void readUsingInputStreamReader(String filePath) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath));
        while (reader.read() != -1) {
            // sirf read kar rahe hain
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {

        // 🔴 YAHAN APNA LARGE FILE PATH DAALO (100MB / 500MB)
        String filePath = "largefile.txt";

        // -------- FileReader Time --------
        long startFileReader = System.nanoTime();
        readUsingFileReader(filePath);
        long endFileReader = System.nanoTime();

        // -------- InputStreamReader Time --------
        long startInputStream = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long endInputStream = System.nanoTime();

        double fileReaderTime = (endFileReader - startFileReader) / 1_000_000.0;
        double inputStreamTime = (endInputStream - startInputStream) / 1_000_000.0;

        // -------- Output --------
        System.out.println("File Size Test Completed");
        System.out.println("FileReader Time: " + fileReaderTime + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamTime + " ms");
    }
}
