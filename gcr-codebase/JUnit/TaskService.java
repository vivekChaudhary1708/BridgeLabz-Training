public class TaskService {

    public static String longRunningTask() throws InterruptedException {
        // Simulate long task (3 seconds)
        Thread.sleep(3000);
        return "Task Completed";
    }
}
