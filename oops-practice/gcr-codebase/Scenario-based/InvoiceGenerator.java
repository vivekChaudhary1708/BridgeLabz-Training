public class InvoiceGenerator {

    // Custom Exception
    static class InvalidInvoiceFormatException extends Exception {
        public InvalidInvoiceFormatException(String message) {
            super(message);
        }
    }

    // Method to parse invoice string
    static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input is empty");
        }

        // Split tasks by comma
        String[] tasks = input.split(",");

        for (String task : tasks) {
            if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException("Missing '-' in task: " + task);
            }

            String[] parts = task.split("-");

            if (parts.length != 2) {
                throw new InvalidInvoiceFormatException("Invalid format in task: " + task);
            }

            String amountPart = parts[1].trim();

            // Check amount exists
            if (!amountPart.matches(".*\\d+.*")) {
                throw new InvalidInvoiceFormatException("Amount missing in task: " + task);
            }
        }

        return tasks;
    }

    // Method to calculate total amount
    static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");

            // Extract number from "3000 INR"
            String amountString = parts[1].replaceAll("[^0-9]", "");

            if (amountString.isEmpty()) {
                throw new InvalidInvoiceFormatException("Invalid amount in task: " + task);
            }

            int amount = Integer.parseInt(amountString);
            total += amount;
        }

        return total;
    }

    // Main Method
    public static void main(String[] args) {

        String invoiceInput = "Logo Design - 3000 INR, Web Page - 4500 INR";

        try {
            String[] tasks = parseInvoice(invoiceInput);

            System.out.println("Invoice Details:");
            for (String task : tasks) {
                System.out.println(task.trim());
            }

            int totalAmount = getTotalAmount(tasks);
            System.out.println("Total Invoice Amount: " + totalAmount + " INR");

        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
