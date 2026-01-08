// Node class
class Student {
    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Singly Linked List class
class StudentSinglyLinkedList {

    Student head;

    // Add at beginning
    void addAtBeginning(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    void addAtEnd(int roll, String name, int age, char grade) {
        Student newNode = new Student(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position (1-based)
    void addAtPosition(int pos, int roll, String name, int age, char grade) {
        if (pos == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }

        Student temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        Student newNode = new Student(roll, name, age, grade);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Search by roll number
    void searchByRoll(int roll) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.roll + " | " + temp.name +
                        " | " + temp.age + " | " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Update grade
    void updateGrade(int roll, char newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Display all records
    void display() {
        if (head == null) {
            System.out.println("No records found");
            return;
        }

        Student temp = head;
        while (temp != null) {
            System.out.println(
                temp.roll + " | " +
                temp.name + " | " +
                temp.age + " | " +
                temp.grade
            );
            temp = temp.next;
        }
    }
}

// Main class
public class StudentRecordApp {
    public static void main(String[] args) {

        StudentSinglyLinkedList list = new StudentSinglyLinkedList();

        list.addAtBeginning(1, "Amit", 20, 'A');
        list.addAtEnd(2, "Ravi", 21, 'B');
        list.addAtPosition(2, 3, "Neha", 19, 'A');

        System.out.println("All Students:");
        list.display();

        list.searchByRoll(2);
        list.updateGrade(2, 'A');

        list.deleteByRoll(1);

        System.out.println("After Deletion:");
        list.display();
    }
}
