import java.util.*;

class Vehicle {
    String number;
    Vehicle next;

    Vehicle(String number) {
        this.number = number;
    }
}

class TrafficManager {
    Vehicle head = null;
    Vehicle tail = null;
    Queue<String> waiting = new LinkedList<>();
    int capacity = 5;

    public void addVehicle(String number) {
        if (size() >= capacity) {
            waiting.add(number);
            return;
        }

        Vehicle v = new Vehicle(number);
        if (head == null) {
            head = tail = v;
            v.next = head;
        } else {
            tail.next = v;
            tail = v;
            tail.next = head;
        }
    }

    public void removeVehicle() {
        if (head == null) return;

        if (head == tail) {
            head = tail = null;
        } else {
            tail.next = head.next;
            head = head.next;
        }

        if (!waiting.isEmpty()) {
            addVehicle(waiting.poll());
        }
    }

    public int size() {
        if (head == null) return 0;
        int count = 1;
        Vehicle temp = head;
        while (temp.next != head) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Vehicle temp = head;
        do {
            System.out.print(temp.number + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}

public class TrafficManagerApp {
    public static void main(String[] args) {
        TrafficManager t = new TrafficManager();

        t.addVehicle("A");
        t.addVehicle("B");
        t.addVehicle("C");
        t.addVehicle("D");
        t.addVehicle("E");
        t.addVehicle("F");

        t.display();
        t.removeVehicle();
        t.display();
    }
}
