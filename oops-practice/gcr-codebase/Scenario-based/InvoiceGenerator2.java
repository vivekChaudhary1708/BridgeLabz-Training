public class InvoiceGenerator {

    // Method to split invoice string into tasks
    static String[] parseInvoice2(String input) {
        // Split by comma
        return input.split(",");
    }

    // Method to calculate total amount
    static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            // Split task name and amount
            String[] parts = task.split("-");

            // Extract amount part like "3000 INR"
            String amountPart = parts[1].trim();

            // Remove non-numeric characters
            String amountStr = amountPart.replaceAll("[^0-9]", "");

            int amount = Integer.parseInt(amountStr);
            total += amount;
        }

        return total;
    }

    // Main Method
    public static void main(String[] args) {

        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        String[] tasks = parseInvoice(input);

        System.out.println("Invoice Details:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }

        int totalAmount = getTotalAmount(tasks);
        System.out.println("Total Invoice Amount: " + totalAmount + " INR");
    }
}
