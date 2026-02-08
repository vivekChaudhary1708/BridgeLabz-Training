import java.util.Random;

// =====================
// Thread class approach
// =====================
class FileDownloaderThread extends Thread {
    private String fileName;

    FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i <= 100; i += 25) {
            try {
                Thread.sleep(random.nextInt(500)); // random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + i + "%");
        }
    }
}

// =========================
// Runnable interface approach
// =========================
class FileDownloaderRunnable implements Runnable {
    private String fileName;

    FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i <= 100; i += 25) {
            try {
                Thread.sleep(random.nextInt(500)); // random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + i + "%");
        }
    }
}

// =====================
// Main class
// =====================
public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Thread class approach ===");

        FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete (Thread approach)!\n");

        System.out.println("=== Runnable interface approach ===");

        Thread r1 = new Thread(new FileDownloaderRunnable("Document.pdf"));
        Thread r2 = new Thread(new FileDownloaderRunnable("Image.jpg"));
        Thread r3 = new Thread(new FileDownloaderRunnable("Video.mp4"));

        r1.start();
        r2.start();
        r3.start();

        r1.join();
        r2.join();
        r3.join();

        System.out.println("All downloads complete (Runnable approach)!");
    }
}
