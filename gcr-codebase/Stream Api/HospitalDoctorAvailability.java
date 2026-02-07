import java.util.*;

public class HospitalDoctorAvailability {

    static class Doctor {
        String name;
        String specialty;
        boolean availableOnWeekend;

        Doctor(String name, String specialty, boolean availableOnWeekend) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekend = availableOnWeekend;
        }
    }

    public static void main(String[] args) {

        List<Doctor> doctors = List.of(
                new Doctor("Dr. Rahul", "Cardiology", true),
                new Doctor("Dr. Amit", "Neurology", false),
                new Doctor("Dr. Neha", "Orthopedic", true),
                new Doctor("Dr. Pooja", "Dermatology", true)
        );

        System.out.println("Doctors Available on Weekends (Sorted by Specialty):");

        doctors.stream()
                // filter doctors available on weekends
                .filter(d -> d.availableOnWeekend)

                // sort by specialty
                .sorted(Comparator.comparing(d -> d.specialty))

                // print result
                .forEach(d ->
                        System.out.println(d.name + " - " + d.specialty)
                );
    }
}
