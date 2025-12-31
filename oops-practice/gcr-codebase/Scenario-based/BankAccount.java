public class BankAccount {

    // Public variable
    public String accountNumber;

    // Protected variable
    protected String accountHolder;

    // Private variable
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Display method
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }

    // Main method
    public static void main(String[] args) {

        SavingsAccount sa = new SavingsAccount(
                "ACC12345",
                "Rahul Kumar",
                15000.0,
                4.5
        );

        sa.displaySavingsDetails();

        // Updating balance using setter
        sa.setBalance(18000);

        System.out.println("\nAfter Balance Update:");
        sa.displaySavingsDetails();
    }
}

// Subclass
class SavingsAccount extends BankAccount {

    double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsDetails() {
        System.out.println("Account Number: " + accountNumber);     // public
        System.out.println("Account Holder: " + accountHolder);     // protected
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Balance: ₹" + getBalance());           // private via getter
    }
}
