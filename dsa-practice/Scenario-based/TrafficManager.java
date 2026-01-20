import java.util.ArrayDeque;
import java.util.Queue;

public class TrafficManager {

    // ========= Circular Linked List Node =========
    private class VehicleNode {
        String vehicle;
        VehicleNode next;

        VehicleNode(String vehicle) {
            this.vehicle = vehicle;
        }
    }

    // Circular Linked List pointers
    private VehicleNode head = null;
    private VehicleNode tail = null;

    // Queue for waiting vehicles
    private Queue<String> waitingQueue;
    private int queueCapacity;

    // ========= Constructor =========
    public TrafficManager(int capacity) {
        this.queueCapacity = capacity;
        this.waitingQueue = new ArrayDeque<>();
    }

    // ========= Add vehicle to waiting queue =========
    public void addToQueue(String vehicle) {
        if (waitingQueue.size() == queueCapacity) {
            System.out.println("Queue Overflow! " + vehicle + " cannot enter.");
            return;
        }
        waitingQueue.offer(vehicle);
        System.out.println(vehicle + " added to waiting queue");
    }

    // ========= Move vehicle from queue to roundabout =========
    public void enterRoundabout() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue Underflow! No vehicle waiting.");
            return;
        }

        String vehicle = waitingQueue.poll();
        VehicleNode newNode = new VehicleNode(vehicle);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }

        System.out.println(vehicle + " entered roundabout");
    }

    // ========= Remove vehicle from roundabout =========
    public void exitRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty!");
            return;
        }

        System.out.println(head.vehicle + " exited roundabout");

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // ========= Print roundabout state =========
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout Empty");
            return;
        }

        System.out.print("Roundabout State: ");
        VehicleNode temp = head;
        do {
            System.out.print(temp.vehicle + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to start)");
    }

    // ========= Main method (testing) =========
    public static void main(String[] args) {

        TrafficManager traffic = new TrafficManager(3);

        traffic.addToQueue("Car-A");
        traffic.addToQueue("Car-B");
        traffic.addToQueue("Car-C");
        traffic.addToQueue("Car-D"); // Overflow

        traffic.enterRoundabout();
        traffic.enterRoundabout();
        traffic.printRoundabout();

        traffic.exitRoundabout();
        traffic.printRoundabout();
    }
}
