// =======================
// Chef Thread Class
// =======================
class Chef extends Thread {
    private String dish;
    private int totalTime; // in milliseconds

    Chef(String chefName, String dish, int totalTime) {
        this.setName(chefName);
        this.dish = dish;
        this.totalTime = totalTime;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started preparing " + dish);

        int[] progress = {25, 50, 75, 100};

        for (int p : progress) {
            try {
                Thread.sleep(totalTime / 4); // divide time into 4 steps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + " preparing " + dish + ": " + p + "% complete");
        }

        System.out.println(getName() + " finished preparing " + dish);
    }
}

// =======================
// Main Class (Manager)
// =======================
public class RestaurantOrderSystem {
    public static void main(String[] args) throws InterruptedException {

        // Create chef threads
        Chef chef1 = new Chef("Chef-1", "Pizza", 3000);
        Chef chef2 = new Chef("Chef-2", "Pasta", 2000);
        Chef chef3 = new Chef("Chef-3", "Salad", 1000);
        Chef chef4 = new Chef("Chef-4", "Burger", 2500);

        // Start cooking
        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();

        // Manager waits for all chefs
        chef1.join();
        chef2.join();
        chef3.join();
        chef4.join();

        System.out.println("Kitchen closed - All orders completed");
    }
}
