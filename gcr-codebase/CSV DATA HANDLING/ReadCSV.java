import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {
    public static void main(String[] args) {

        String filePath = "students.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); // header skip

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("ID: " + data[0]
                        + ", Name: " + data[1]
                        + ", Age: " + data[2]
                        + ", Marks: " + data[3]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
