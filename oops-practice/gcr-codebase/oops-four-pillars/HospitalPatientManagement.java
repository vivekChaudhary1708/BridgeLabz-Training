// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Class
abstract class Patient {

    // Encapsulation: private fields
    private int patientId;
    private String name;
    private int age;

    // Sensitive data (protected indirectly)
    private String medicalHistory = "";

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Protected access for subclasses
    protected void addToMedicalHistory(String record) {
        medicalHistory += record + "; ";
    }

    protected String getMedicalHistoryMasked() {
        if (medicalHistory.isEmpty()) {
            return "No Records";
        }
        return "Records Available";
    }

    // Abstract method
    abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Medical History: " + getMedicalHistoryMasked());
    }
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        addToMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient medical records added.");
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addToMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient medical records added.");
    }
}

// Main Class
public class HospitalPatientManagement {

    public static void main(String[] args) {

        // Polymorphism: Patient reference
        Patient[] patients = new Patient[2];

        patients[0] = new InPatient(1, "Rahul", 30, 5, 2000);
        patients[1] = new OutPatient(2, "Aman", 25, 800);

        // Adding medical records
        ((MedicalRecord) patients[0]).addRecord("Surgery");
        ((MedicalRecord) patients[1]).addRecord("Fever Consultation");

        // Display patient details and billing
        for (Patient p : patients) {

            p.getPatientDetails();
            System.out.println("Total Bill: " + p.calculateBill());
            System.out.println();
        }
    }
}
