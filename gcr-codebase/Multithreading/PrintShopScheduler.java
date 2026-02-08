// =======================
// PrintJob class (Runnable)
// =======================
class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    // shared printer lock
    private static final Object printer = new Object();

    PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        // only one job can use printer at a time
        synchronized (printer) {
            for (int i = 1; i <= pages; i++) {
                try {
                    Thread.sleep(100); // 100ms per page
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("[" + getPriorityLabel() + "] Printing " +
                        jobName + " - Page " + i + " of " + pages);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(jobName + " completed in " +
                (endTime - startTime) + " ms");
    }

    private String getPriorityLabel() {
        if (priority >= 8) return "High Priority";
        if (priority >= 5) return "Medium Priority";
        return "Low Priority";
    }
}

// =======================
// Main Class
// =======================
public class PrintShopScheduler {

    public static void main(String[] args) throws InterruptedException {

        long totalStart = System.currentTimeMillis();

        System.out.println("Starting print jobs...\n");

        // Create print jobs
        Thread t1 = new Thread(new PrintJob("Job1", 10, 5), "Job1");
        Thread t2 = new Thread(new PrintJob("Job2", 5, 8), "Job2");
        Thread t3 = new Thread(new PrintJob("Job3", 15, 3), "Job3");
        Thread t4 = new Thread(new PrintJob("Job4", 8, 6), "Job4");
        Thread t5 = new Thread(new PrintJob("Job5", 12, 7), "Job5");

        // Set thread priorities
        t1.setPriority(5); // Medium
        t2.setPriority(8); // High
        t3.setPriority(3); // Low
        t4.setPriority(6); // Medium
        t5.setPriority(7); // Medium-High

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        // Wait for all jobs to finish
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        long totalEnd = System.currentTimeMillis();

        System.out.println("\nAll jobs completed in " +
                (totalEnd - totalStart) + " ms");
    }
}
