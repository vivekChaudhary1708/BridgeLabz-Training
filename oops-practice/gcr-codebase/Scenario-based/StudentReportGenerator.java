class InvalidMarkException extends Exception {
    InvalidMarkException(String msg) {
        super(msg);
    }
}

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() throws InvalidMarkException {
        int sum = 0;
        for (int m : marks) {
            if (m < 0 || m > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
            sum += m;
        }
        return sum / (double) marks.length;
    }

    String getGrade(double avg) {
        if (avg >= 75) return "A";
        if (avg >= 50) return "B";
        return "C";
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) throws Exception {
        int[] marks = {80, 70, 75};

        Student s = new Student("Vivek", marks);

        double avg = s.calculateAverage();

        System.out.println("Name: " + s.name);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + s.getGrade(avg));
    }
}
