import java.util.Date;

// =======================
// TaskRunner Thread
// =======================
class TaskRunner extends Thread {

    TaskRunner(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            // RUNNABLE (some computation)
            for (int i = 0; i < 1000000; i++) {
                int x = i * i;
            }

            // TIMED_WAITING
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
    }
}

// =======================
// StateMonitor Thread
// =======================
class StateMonitor extends Thread {
    private Thread[] threads;
    private boolean running = true;

    StateMonitor(Thread[] threads) {
        this.threads = threads;
        setName("Monitor");
    }

    @Override
    public void run() {
        while (running) {
            running = false;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                System.out.println("[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + new Date());

                if (state != Thread.State.TERMINATED) {
                    running = true;
                }
            }

            try {
                Thread.sleep(500); // check every 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("--------------------------------");
        }
    }
}

// =======================
// Main Class
// =======================
public class ThreadStateMonitoring {
    public static void main(String[] args) throws InterruptedException {

        // Create TaskRunner threads
        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        Thread[] tasks = { t1, t2 };

        // Create StateMonitor
        StateMonitor monitor = new StateMonitor(tasks);

        // NEW state
        System.out.println("Before start:");
        System.out.println(t1.getName() + " -> " + t1.getState());
        System.out.println(t2.getName() + " -> " + t2.getState());
        System.out.println("--------------------------------");

        // Start threads
        t1.start();
        t2.start();
        monitor.start();

        // Wait for completion
        t1.join();
        t2.join();
        monitor.join();

        // Summary
        System.out.println("Summary:");
        System.out.println("Task-1 went through states: NEW → RUNNABLE → TIMED_WAITING → TERMINATED");
        System.out.println("Task-2 went through states: NEW → RUNNABLE → TIMED_WAITING → TERMINATED");
    }
}
