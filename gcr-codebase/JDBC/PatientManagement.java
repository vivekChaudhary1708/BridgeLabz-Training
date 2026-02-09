import java.util.*;
import java.sql.*;

public class PatientManagement {

    // JDBC details (example)
    static final String URL = "jdbc:mysql://localhost:3306/hospitaldb";
    static final String USER = "root";
    static final String PASS = "password";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Register Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Search Patient");
            System.out.println("4. View Patient Visit History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    updatePatient();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    viewVisitHistory();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // UC-1.1 Register New Patient
    static void registerPatient() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter DOB: ");
            String dob = sc.nextLine();

            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter address: ");
            String address = sc.nextLine();

            System.out.print("Enter blood group: ");
            String blood = sc.nextLine();

            String checkSql = "SELECT * FROM patients WHERE phone=? OR email=?";
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setString(1, phone);
            checkPs.setString(2, email);

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                System.out.println("Patient already exists!");
                return;
            }

            String insertSql = "INSERT INTO patients(name, dob, phone, email, address, blood_group) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.setString(6, blood);

            ps.executeUpdate();
            System.out.println("Patient registered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UC-1.2 Update Patient Information
    static void updatePatient() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new address: ");
            String address = sc.nextLine();

            String sql = "UPDATE patients SET address=? WHERE patient_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, address);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Patient updated successfully");
            else
                System.out.println("Patient not found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UC-1.3 Search Patient Records
    static void searchPatient() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter name or phone: ");
            String input = sc.nextLine();

            String sql = "SELECT * FROM patients WHERE name LIKE ? OR phone=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + input + "%");
            ps.setString(2, input);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("patient_id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UC-1.4 View Patient Visit History
    static void viewVisitHistory() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            System.out.print("Enter patient ID: ");
            int id = sc.nextInt();

            String sql =
                    "SELECT a.date, d.doctor_name, v.diagnosis " +
                    "FROM appointments a " +
                    "JOIN visits v ON a.appointment_id = v.appointment_id " +
                    "JOIN doctors d ON a.doctor_id = d.doctor_id " +
                    "WHERE a.patient_id=? ORDER BY a.date";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getDate("date") + " | " +
                        rs.getString("doctor_name") + " | " +
                        rs.getString("diagnosis"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
