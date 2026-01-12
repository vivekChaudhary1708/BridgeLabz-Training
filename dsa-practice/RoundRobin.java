class Process {
    int id, burst, priority;
    Process next;

    Process(int i, int b, int p) {
        id = i; burst = b; priority = p;
    }
}

public class RoundRobin {
    static Process head = null, tail = null;
    static int tq = 3;

    static void add(Process p) {
        if (head == null) {
            head = tail = p;
            p.next = head;
        } else {
            tail.next = p;
            tail = p;
            tail.next = head;
        }
    }

    static void run() {
        Process cur = head;
        while (head != null) {
            if (cur.burst > tq) {
                cur.burst -= tq;
                cur = cur.next;
            } else {
                remove(cur.id);
                cur = head;
            }
            display();
        }
    }

    static void remove(int id) {
        Process cur = head, prev = tail;
        do {
            if (cur.id == id) {
                if (cur == head) head = head.next;
                prev.next = cur.next;
                if (cur == tail) tail = prev;
                if (head == cur) head = null;
                return;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != head);
    }

    static void display() {
        if (head == null) return;
        Process t = head;
        do {
            System.out.print(t.id + "(" + t.burst + ") ");
            t = t.next;
        } while (t != head);
        System.out.println();
    }

    public static void main(String[] args) {
        add(new Process(1,8,1));
        add(new Process(2,5,1));
        add(new Process(3,4,1));
        run();
    }
}
