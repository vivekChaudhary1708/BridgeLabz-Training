class FitnessTracker {
    public static void main(String[] args) {

        int[] pushUps = {30, 0, 25, 40, 0, 50, 20};
        int total = 0;
        int days = 0;

        for (int push : pushUps) {
            if (push == 0) {
                continue; // rest day
            }
            total += push;
            days++;
        }

        double average = (double) total / days;

        System.out.println("Total Pushups: " + total);
        System.out.println("Average Pushups: " + average);
    }
}
