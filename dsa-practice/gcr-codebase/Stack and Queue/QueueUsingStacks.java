import java.util.Stack;

public class QueueUsingStacks {

    // Inner Queue class
    static class MyQueue {
        private Stack<Integer> s1;   // For enqueue
        private Stack<Integer> s2;   // For dequeue

        // Constructor
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // Enqueue
        public void enqueue(int x) {
            s1.push(x);
        }

        // Dequeue
        public int dequeue() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            if (s2.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s2.pop();
        }

        // Peek front
        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            if (s2.isEmpty()) return -1;

            return s2.peek();
        }

        // Check empty
        public boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    // Main method
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        q.enqueue(40);

        System.out.println(q.peek());    // 30
        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // 40
        System.out.println(q.isEmpty()); // true
    }
}
