import java.util.*;

class AppointmentNotAvailableException extends Exception {
    public AppointmentNotAvailableException(String msg) {
        super(msg);
    }
}

interface HospitalService {
    Appointment bookAppointment(Patient p, Doctor d) throws AppointmentNotAvailableException;
    void cancelAppointment(Appointment a);
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

class Patient extends Person {
    List<String> medicalHistory = new ArrayList<>();

    public Patient(String name) {
        super(name);
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public void viewHistory() {
        for (String s : medicalHistory) {
            System.out.println(s);
        }
    }
}

class Doctor extends Person {
    boolean available = true;

    public Doctor(String name) {
        super(name);
    }

    public double getConsultationFee() {
        return 300;
    }
}

class SpecialistDoctor extends Doctor {
    public SpecialistDoctor(String name) {
        super(name);
    }

    public double getConsultationFee() {
        return 600;
    }
}

class Appointment {
    Patient patient;
    Doctor doctor;

    public Appointment(Patient p, Doctor d) {
        this.patient = p;
        this.doctor = d;
    }
}

class Hospital implements HospitalService {
    List<Appointment> appointments = new ArrayList<>();

    public Appointment bookAppointment(Patient p, Doctor d) throws AppointmentNotAvailableException {
        if (!d.available) {
            throw new AppointmentNotAvailableException("Doctor not available");
        }
        d.available = false;
        Appointment a = new Appointment(p, d);
        appointments.add(a);
        return a;
    }

    public void cancelAppointment(Appointment a) {
        a.doctor.available = true;
        appointments.remove(a);
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Hospital h = new Hospital();

        Patient p1 = new Patient("Vivek");
        Doctor d1 = new Doctor("Dr Ravi");
        Doctor d2 = new SpecialistDoctor("Dr Mehta");

        try {
            Appointment a1 = h.bookAppointment(p1, d1);
            System.out.println(a1.doctor.name + " " + a1.doctor.getConsultationFee());

            h.cancelAppointment(a1);

            Appointment a2 = h.bookAppointment(p1, d2);
            System.out.println(a2.doctor.name + " " + a2.doctor.getConsultationFee());

        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        p1.addRecord("Fever");
        p1.addRecord("Blood Test");

        p1.viewHistory();
    }
}
