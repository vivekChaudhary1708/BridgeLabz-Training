

class Course {
    String courseName;
    int duration; // in weeks

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    String getCourseDetails() {
        return "Course Name: " + courseName +
               "\nDuration: " + duration + " weeks";
    }
}

// Level 2: OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    String getCourseDetails() {
        return super.getCourseDetails() +
               "\nPlatform: " + platform +
               "\nRecorded: " + isRecorded;
    }
}

// Level 3: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount; // percentage

    PaidOnlineCourse(String courseName, int duration, String platform,
                     boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    double getFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    String getCourseDetails() {
        return super.getCourseDetails() +
               "\nFee: " + fee +
               "\nDiscount: " + discount + "%" +
               "\nFinal Fee: " + getFinalFee();
    }
}

// Main class
public class EducationalCourseHierarchy {
    public static void main(String[] args) {

        Course c1 = new Course("Core Java", 6);
        Course c2 = new OnlineCourse("DSA Online", 8, "Udemy", true);
        Course c3 = new PaidOnlineCourse("MERN Stack", 12, "Coursera", true, 15000, 20);

        System.out.println(c1.getCourseDetails());
        System.out.println("-------");
        System.out.println(c2.getCourseDetails());
        System.out.println("--------");
        System.out.println(c3.getCourseDetails());
    }
}
