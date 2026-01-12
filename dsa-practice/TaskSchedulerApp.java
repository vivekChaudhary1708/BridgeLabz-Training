class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task t = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = t;
            t.next = head;
            current = head;
        } else {
            t.next = head;
            tail.next = t;
            head = t;
        }
    }

    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task t = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = t;
            t.next = head;
            current = head;
        } else {
            tail.next = t;
            tail = t;
            tail.next = head;
        }
    }

    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Task t = new Task(id, name, priority, dueDate);
        t.next = temp.next;
        temp.next = t;

        if (temp == tail) {
            tail = t;
        }
    }

    public void removeById(int id) {
        if (head == null) return;

        Task curr = head;
        Task prev = tail;

        do {
            if (curr.id == id) {
                if (curr == head) {
                    head = head.next;
                    tail.next = head;
                } else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = curr.next;
                }
                if (current == curr) current = head;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void viewCurrentTask() {
        if (current == null) return;
        System.out.println(current.id + " " + current.name + " " + current.priority + " " + current.dueDate);
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
        }
    }

    public void displayAll() {
        if (head == null) return;

        Task temp = head;
        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;

        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.id + " " + temp.name + " " + temp.dueDate);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();

        ts.addAtEnd(1, "Coding", 1, "10-Apr");
        ts.addAtEnd(2, "Testing", 2, "12-Apr");
        ts.addAtBeginning(3, "Design", 1, "09-Apr");
        ts.addAtPosition(2, 4, "Review", 3, "11-Apr");

        ts.displayAll();

        System.out.println();
        ts.viewCurrentTask();
        ts.moveToNextTask();
        ts.viewCurrentTask();

        System.out.println();
        ts.searchByPriority(1);

        ts.removeById(2);
        System.out.println();
        ts.displayAll();
    }
}
