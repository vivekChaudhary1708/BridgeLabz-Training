import java.util.PriorityQueue;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String msg) {
        super(msg);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority;

    BackupTask(String folderPath, int priority) {
        this.folderPath = folderPath;
        this.priority = priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        return other.priority - this.priority; // high priority first
    }
}

public class FileBackupScheduler {

    PriorityQueue<BackupTask> queue = new PriorityQueue<>();

    void addBackupTask(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        queue.add(new BackupTask(path, priority));
    }

    void executeBackups() {
        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println("Backing up: " + task.folderPath +
                               " (Priority: " + task.priority + ")");
        }
    }

    public static void main(String[] args) {
        FileBackupScheduler scheduler = new FileBackupScheduler();

        try {
            scheduler.addBackupTask("/system", 5);
            scheduler.addBackupTask("/documents", 2);
            scheduler.addBackupTask("/photos", 3);
        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        scheduler.executeBackups();
    }
}
